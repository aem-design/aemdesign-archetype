let fs = require('fs');

let template = ``;
let icons = [
  { name: "fal fa-home", class: "Home" },
  { name: "fal fa-chevron-right", class: "Chevron Right" },
  { name: "fal fa-calculator", class: "Calculator" },
  { name: "fal fa-briefcase", class: "Briefcase" },
  { name: "fal fa-fast-forward", class: "Fast Forward" },
  { name: "fal fa-comments", class: "Comments" },
  { name: "fal fa-search", class: "Search" },
  { name: "fal fa-calendar", class: "Calendar" },
  { name: "fal fa-calendar-alt", class: "Calendar Alt" },
  { name: "fal fa-edit", class: "Edit" },
  { name: "fal fa-phone", class: "Phone" },
  { name: "fal fa-pencil-alt", class: "Pencil Alt" },
  { name: "fal fa-book", class: "Book" },
  { name: "fal fa-reply-all", class: "Reply All" },
  { name: "fal fa-life-ring", class: "Life Ring" },
  { name: "fal fa-envelope", class: "Envelope" },
  { name: "fal fa-star", class: "Star" },
  { name: "fal fa-car", class: "Car" },
  { name: "fal fa-street-view", class: "Street View" },
  { name: "fal fa-globe", class: "Globe" },
  { name: "fal fa-train", class: "Train" },
  { name: "fal fa-play-circle", class: "Play Circle" },
  { name: "fal fa-user", class: "User" },
  { name: "fal fa-users", class: "Users" },
  { name: "fal fa-users-class", class: "Users Class" },
  { name: "fal fa-user-graduate", class: "User Graduate" },
  { name: "fal fa-balance-scale", class: "Balance Scale" },
  { name: "fal fa-building", class: "Building" },
  { name: "fal fa-chalkboard-teacher", class: "Chalkboard Teacher" },
  { name: "fal fa-child", class: "Child" },
  { name: "fal fa-comment-alt-exclamation", class: "Comment Al Exclamation" },
  { name: "fal fa-comment-alt-smile", class: "Comment Alt Smile" },
  { name: "fal fa-comment-alt-check", class: "Comment Alt Check" },
  { name: "fal fa-comment-alt-dots", class: "Comment Alt Dots" },
  { name: "fal fa-comments-alt", class: "Comment Alt" },
  { name: "fal fa-info-circle", class: "Info Circle" },
  { name: "fal fa-laptop", class: "Laptop" },
  { name: "fal fa-location-circle", class: "Location Circle" },
  { name: "fal fa-map-pin", class: "Map pin" },
  { name: "fal fa-plane-arrival", class: "Plane Arrival" },
  { name: "fal fa-plane-departure", class: "Plane Departure" },
  { name: "fal fa-thumbs-up", class: "Thumbs Up" },
  { name: "fal fa-thumbs-down", class: "Thumbs Down" },
  { name: "fal fa-trophy", class: "Trophy" },
  { name: "fal fa-wheelchair", class: "Wheelchair" },
  { name: "fal fa-star", class: "Star" },
  { name: "fal fa-school", class: "School" },
  { name: "fal fa-paper-plane", class: "Paper Plane" },
  { name: "fal fa-newspaper", class: "Newspaper" },
  { name: "fal fa-chart-bar", class: "Chart Bar" },
  { name: "fal fa-university", class: "University" },
  { name: "fal fa-video", class: "Video" },
  { name: "fal fa-graduation-cap", class: "Graduation Cap" },
  { name: "fal fa-cogs", class: "Cogs" },
  { name: "fal fa-gamepad", class: "Gamepad" },
  { name: "fal fa-code", class: "Code" },
  { name: "fal fa-gavel", class: "Gavel" },
  { name: "fal fa-stethoscope", class: "Stethoscope" },
  { name: "fal fa-flask", class: "Flask" },
  { name: "fal fa-wrench", class: "Wrench" },
  { name: "fal fa-heartbeat", class: "Heartbeat" },
  { name: "fal fa-link", class: "Link" },
  { name: "fab fa-connectdevelop", class: "Connectdevelop" },
  { name: "fab fa-facebook-f", class: "Facebook F" },
  { name: "fab fa-facebook", class: "Facebook" },
  { name: "fab fa-instagram", class: "Instagram" },
  { name: "fab fa-twitter", class: "Twitter" },
  { name: "fab fa-pinterest-p", class: "Pinterest P" },
  { name: "fab fa-linkedin-in", class: "Linkedin In" },
  { name: "fab fa-linkedin", class: "Linkedin" },
  { name: "fab fa-youtube", class: "Youtube" },
  { name: "fab fa-tumblr-square", class: "Tumblr Square" },
  { name: "fab fa-tumblr", class: "Tumblr" }
];

let row_index = 0;
icons.forEach( (icon, index) => {
  if(row_index === 0) template += `<div id="icon-section-${index}" class="row">`;
  template += `<div class="col-xl-3 col-lg-4 col-sm-6 icon"><span class="${icon.name}"></span><span>${icon.class}</span></div>`;
  row_index++;
  if(row_index === 12 || !icons[index + 1]) {
    template += `</div>`;
    row_index = 0;
  }
});


fs.writeFile ("../html/icons.html", template, function(err) {
    if (err) throw err;
    console.log('complete');
  }
);
