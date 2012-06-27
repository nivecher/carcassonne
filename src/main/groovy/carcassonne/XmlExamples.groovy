/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package carcassonne

import groovy.xml.MarkupBuilder
import org.custommonkey.xmlunit.*

def writer = new StringWriter()
def xml = new MarkupBuilder(writer)
xml.records() {
  car(name:'HSV Maloo', make:'Holden', year:2006) {
    country('Australia')
    record(type:'speed', 'Production Pickup Truck with speed of 271kph')
  }
  car(name:'P50', make:'Peel', year:1962) {
    country('Isle of Man')
    record(type:'size', 'Smallest Street-Legal Car at 99cm wide and 59 kg in weight')
  }
  car(name:'Royale', make:'Bugatti', year:1931) {
    country('France')
    record(type:'price', 'Most Valuable Car at $15 million')
  }
}

//XMLUnit.setIgnoreWhitespace(true)
//def xmlDiff = new Diff(writer.toString(), XmlExamples.CAR_RECORDS)
//assert xmlDiff.similar()

class XmlExamples {
  static def CAR_RECORDS = '''
    <records>
      <car name='HSV Maloo' make='Holden' year='2006'>
        <country>Australia</country>
        <record type='speed'>Production Pickup Truck with speed of 271kph</record>
      </car>
      <car name='P50' make='Peel' year='1962'>
        <country>Isle of Man</country>
        <record type='size'>Smallest Street-Legal Car at 99cm wide and 59 kg in weight</record>
      </car>
      <car name='Royale' make='Bugatti' year='1931'>
        <country>France</country>
        <record type='price'>Most Valuable Car at $15 million</record>
      </car>
    </records>
  '''
}