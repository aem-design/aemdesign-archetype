import { render } from 'react-dom'

import Spreadsheet from './prototype/spreadsheet.jsx'

$(() => {

  // Render the spreadsheet
  renderSpreadsheet()

})

function renderSpreadsheet() {
  render(
    <Spreadsheet />,
    document.querySelector('#spreadsheet')
  )
}

// HMR (Hot Module Replacement)
if (module.hot) {
  // module.hot.accept('./prototype/spreadsheet.jsx', renderSpreadsheet)
}
