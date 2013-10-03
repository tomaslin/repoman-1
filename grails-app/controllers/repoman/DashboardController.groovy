package repoman
import groovy.json.JsonSlurper
import java.net.URL
/**
 * Comtroller
 */
class DashboardController
{

    def githubService

    def index(){
        githubService?.getRepoNames()
        def asgardCommits = new JsonSlurper().parseText('https://api.github.com/repos/Netflix/asgard/commits'.toURL().text)
        // println asgardCommits
            println asgardCommits[0].commit.committer.date

            boolean isAsgardActive = githubService?.isActiveRepo(asgardCommits[0].commit)
        String friggaText = 'https://api.github.com/repos/Netflix/frigga/commits'.toURL().text

        def friggaCommits = new JsonSlurper().parseText(friggaText)
         [isActive: [isAsgardActive, githubService?.isActiveRepo(friggaCommits[0].commit)]

        ]

    }
}