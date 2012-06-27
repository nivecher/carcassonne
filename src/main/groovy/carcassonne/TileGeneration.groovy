/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package carcassonne

// require(groupId:'xmlunit', artifactId:'xmlunit', version:'1.0')
import groovy.xml.MarkupBuilder
//import org.custommonkey.xmlunit.*

def writer = new StringWriter()
def xml = new MarkupBuilder(writer)

/*
<ns1:tile id="A" instances="2">
<ns1:cloister/>
<ns1:field>
<ns1:edge>north</ns1:edge>
<ns1:edge>east</ns1:edge>
<ns1:edge>south</ns1:edge>
<ns1:edge>west</ns1:edge>
</ns1:field>
<ns1:road>
<ns1:edge>south</ns1:edge>
</ns1:road>
</ns1:tile>
 */

xml.tileSet(xmlns: 'urn:carcassone:basic:tiles') {
    tile(id:'A', instances: 2) {
        cloister()
        field() {
            edge('north')
            edge('east')
            edge('south')
            edgeSegment('south-east')
            edgeSegment('south-west')
        }
        road(description: 'Road from cloister to south edge') {
            edge('south')
        }
    }
    tile(id:'B', instances: 4) {
        cloister()
        field() {
            edge('north')
            edge('south')
            edge('east')
            edge('west')
        }
    }
    
    // TODO add C...
}

println writer.toString()

