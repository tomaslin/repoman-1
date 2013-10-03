package repoman

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(DashboardController)
class DashboardControllerSpec extends Specification {


    void "should show repos"() {
        when:
        def result = controller.index()

        then:
        result.isActive.size() != null
    }
}
