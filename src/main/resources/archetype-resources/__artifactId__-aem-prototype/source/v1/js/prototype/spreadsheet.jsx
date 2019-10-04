import { Component } from 'react'
import { hot } from 'react-hot-loader'
import HotTable from 'react-handsontable'

class Spreadsheet extends Component {
  data = [
    // Policy inputs
    ['Start Date', '1/01/2007'],
    ['Investment amount', 300000],
    ['Age', 64],
    ['Super or not', 'Y'],
    [''],

    // Year 1
    ['Year 1'],
    ['', '-10%', '-5%', '0%'],
    ['ASX', '15%', '15%', '15%', '45%'],
    ['MSCI', '15%', '15%', '15%', '45%'],
    ['Fixed interest', '', '', '', '10%'],
    ['Total', '=SUM(B8:B9)', '=SUM(C8:C9)', '=SUM(D8:D9)', '=SUM(E8:B10)'],
  ]

  render() {
    return (
      <HotTable
        autoWrapRow={true}
        colHeaders={true}
        data={this.data}
        formulas={true}
        minCols={10}
        minRows={30}
        minSpareCols={1}
        minSpareRows={1}
        rowHeaders={true}
        stretchH="all"
      />
    )
  }
}

export default hot(module)(Spreadsheet)
