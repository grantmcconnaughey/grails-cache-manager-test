package cache.test

import grails.transaction.Transactional
import grails.plugin.cache.Cacheable

@Transactional
class PersonService {

    @Cacheable('cacheManagerPersonCache')
    def getPersonList() {
        Person.list()
    }

    @Cacheable('cacheManagerMultiplePersonCache')
    def getMultiplePersonLists(Integer numberOfLists) {
        def personLists = []
        numberOfLists.times {
            personLists << Person.list()
        }
    }
}
