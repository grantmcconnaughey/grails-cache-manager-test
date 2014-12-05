import org.apache.commons.lang.RandomStringUtils
import cache.test.*

class BootStrap {

    def init = { servletContext ->
        println 'Saving Persons...'
        100000.times { i ->
            def p = new Person()
            p.firstName = RandomStringUtils.randomAlphabetic(8)
            p.lastName = RandomStringUtils.randomAlphabetic(13)
            p.age = RandomStringUtils.randomNumeric(2).toInteger()
            p.save()

            if (i % 10000 == 0) {
                println "\t${i}"
            }
        }
        println '...done saving Persons.'
    }
    def destroy = {
    }
}
