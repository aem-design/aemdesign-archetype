/**
 * Dynamically embeds video media and sets up analytics
 */

import ResponsiveIframes from './responsive-iframes';

const videos = {}; // object to store video information. Indexed by component id attribute
let youTubeScriptAttached = false;
let kalturaScriptAttached = false;

/**
 * Retrieves a given video's information from the object videos (see above)
 *
 * @param {id} ID attribute of video component
 */
const getVideoDetails = (id) => {
  return videos[id];
}

/**
 * Sets a given video's status to complete and executes the analytics update
 *
 * @param {id} ID attribute of video component
 */
const videoFinish = (id) => {
  videos[id].lastWatchedSegment = 10;
  setAnalytics(id);
  clearTimer(id);
};

/**
 * Clears the Interval timer that watches while a video is playing
 *
 * @param {id} ID attribute of video component
 */
const clearTimer = (id) => {
  const { timer } = getVideoDetails(id);
  if (timer) {
    clearInterval(timer);
    videos[id].timer = null;
  }
};

/**
 * Handles a state change of a given media player.
 *
 * @param {Object} State change event, provided by 3rd party API
 * @param {id} ID attribute of video component
 */
const onPlayerStateChange = (event, id) => {
  const { provider } = getVideoDetails(id);

  if ((provider === "youtube" && event.data === 1) // start playing
  || (provider === "kaltura" && event === 'playing')) {
    clearTimer(id);
    videos[id].timer = setInterval(record.bind(this, id), 100);
  } else if ((provider === 'youtube') // any other youtube state change is considered a pause
  || (provider === 'kaltura' && event === 'paused')) { // kaltura paused playing
    if ((provider==="youtube" && event.data === 0)) { // youtube finished playing
      videoFinish(id);
    } else {
      clearTimer(id);
    }
  }
};

/**
 * Checks the current progress of the given video. If the video watched time has progressed by at least 10%, then
 * execute analytics update
 *
 * @param {id} ID attribute of video component
 */
const record = (id) => {
  const {
    player,
    lastWatchedSegment,
    provider
  } = getVideoDetails(id);

  let duration;
  let currentTime;

  if (provider === 'youtube') {
    duration = player.getDuration();
    currentTime = player.getCurrentTime();
  } else if (provider === 'kaltura') {
    duration = player.evaluate('{duration}');
    currentTime = player.evaluate('{video.player.currentTime}');
  }

  const currentSegment = Math.floor(currentTime / duration * 10);

  if (currentSegment !== lastWatchedSegment) {
    videos[id].lastWatchedSegment = currentSegment;
    setAnalytics(id);
  }
};

/**
 * Updates the window's analytics object with details of a given video
 *
 * @param {id} ID attribute of video component
 */
const setAnalytics = (id) => {
  const {
    lastWatchedSegment,
    iframe,
    provider,
    title
  } = getVideoDetails(id);

  if (!window.digitalData) {
    window.digitalData = {
      event: []
    }
  }

  window.digitalData.video = {
    title,
    progress: `${lastWatchedSegment}0`, // percentage value in 10% increments, eg '10', '20', '30' etc
    provider: provider
  };
  window.digitalData.event.push({"eventAction" : "video-interact"});
};

/**
* Dynamically loads 3rd party javascript files into the page. Returns a promise that resolves after done.
*
* @param {String} Provider, either 'youtube' or 'kaltura'
*/
const loadScripts = (provider) => {
  return new Promise((resolve) => {
    let source;
    if (provider === 'youtube') {
      if (youTubeScriptAttached) { resolve(); } // check if script is already attached
      source = 'https://www.youtube.com/iframe_api';
    } else if (provider === 'kaltura') {
      if (kalturaScriptAttached) { resolve(); } // check if script is already attached
      source = 'https://cdnapisec.kaltura.com/p/691292/sp/69129200/embedIframeJs/uiconf_id/20499062/partner_id/691292';
    }

    const tag = document.createElement('script');
    tag.src = source;
    const firstScriptTag = document.getElementsByTagName('script')[0];
    firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

    tag.addEventListener('load', () => {
      if (provider === 'youtube') { youTubeScriptAttached = true; }
      if (provider === 'kaltura') { kalturaScriptAttached = true; }
      resolve();
    });
  })
};

/**
 * Stores the details for a given video
 *
 * @param {id} ID attribute of video component
 */
const createVideoDetails = ({ id, player, provider, title }) => {
  if (!videos[id]) {
    videos[id] = {
      player,
      timer: null,
      lastWatchedSegment: null,
      provider,
      title
    }
  }
};

/**
 * Dynamically loads an embedded video in each of the given set of nodes.
 *
 * @param {NodeList or Array} Array of nodes
 */
const initializeComponents = (components) => {
  // use Array prototype method for IE11 compatibility
  Array.prototype.forEach.call (components, (component) => {
    const id = component.getAttribute('id');
    const videoDiv = component.querySelector('.contents');
    const source = videoDiv.getAttribute('src');
    const entryId = component.getAttribute('data-mediaid');
    const provider = component.getAttribute('data-mediaprovider');
    const title = component.getAttribute('data-mediatitle');
    const width = component.getAttribute('width');
    const height = component.getAttribute('height');
    let player;

    if (width) { component.style.width = `${width}px`; }
    if (height) { component.style.height = `${height}px`; }

    if (provider === 'youtube') {
      player = new YT.Player(videoDiv, {
        videoId: entryId,
        events: {
          'onStateChange': (event) => {
            onPlayerStateChange(event, id);
          }
        }
      });
      createVideoDetails({
        id,
        player,
        provider,
        title
      });
    } else if (provider === 'kaltura') {
      let videoId = videoDiv.getAttribute('id');
      if (!videoId) {
        videoId = `${id}-video`;
        videoDiv.setAttribute('id', videoId);
      }
      const playerId = component.getAttribute('data-mediaplayerid');
      const partnerId = component.getAttribute('data-mediapartnerid');

      kWidget.addReadyCallback( function(kalturaPlayerId) {
        player = document.getElementById(kalturaPlayerId);
        createVideoDetails({
          id,
          player,
          provider,
          title
        });

        player.kBind('playerStateChange', (event) => {
          onPlayerStateChange(event, id);
        });

        player.kBind('playerPlayEnd', () => {
          videoFinish(id);
        });
      });

      kWidget.embed({
        targetId: videoId, // kaltura requires an ID on the div
        wid: partnerId, // partner id, specific to kaltura account
        uiconf_id: playerId, // ui config, set up in kaltura
        entry_id: entryId // unique identifier of video
      });
    }
  });
  ResponsiveIframes();
};

/**
 * Checks if embedded video components are on the page and if so, initializes them
 */
export default () => {
  const youTubeVideos =  document.querySelectorAll('.onlinemedia[data-mediaprovider="youtube"]:not(.iframe)');
  const kalturaVideos =  document.querySelectorAll('.onlinemedia[data-mediaprovider="kaltura"]:not(.iframe)');
  if (youTubeVideos.length) {
    loadScripts('youtube').then(() => {
      window.onYouTubeIframeAPIReady = () => {
        initializeComponents(youTubeVideos);
      }
    });
  }
  if (kalturaVideos.length) {
    loadScripts('kaltura').then(() => {
      initializeComponents(kalturaVideos);
    });
  }
}
