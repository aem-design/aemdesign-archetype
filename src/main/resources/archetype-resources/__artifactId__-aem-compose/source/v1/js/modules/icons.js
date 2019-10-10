/* global fontawesome */
import {
  faFacebook,
  faGooglePlusG,
  faTwitter,
} from '@fortawesome/fontawesome-free-brands'

export default () => {
  console.info('Font Awesome is in da house!!', fontawesome)

  // Add the icons into the library
  // fontawesome.library.add(faFacebook)
  // fontawesome.library.add(faGooglePlusG)
  // fontawesome.library.add(faTwitter)

  fontawesome.library.add([
    faFacebook,
    faGooglePlusG,
    faTwitter,
  ])
}
