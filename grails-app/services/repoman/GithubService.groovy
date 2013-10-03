package repoman


import groovy.json.JsonSlurper
import groovy.lang.GString
import groovy.lang.Closure
import groovy.lang.ObjectRange
import javax.xml.bind.DatatypeConverter

public class GithubService {


    public static allRepoNamesJson
    static private Vector all_repo_names

    public GithubService() {
        try {allRepoNamesJson =   new JsonSlurper().parseText('https://api.github.com/orgs/Netflix/repos'.toURL().text)

            } catch(Throwable  throwable) {
                //TODO REtry it?
            }
        }
    static List getRepoNames()
    {
         all_repo_names = allRepoNamesJson.collect { it.name}
//         all_repo_names = allRepoNamesJson.collect { it.name}


        return all_repo_names
    }

    /**
     *
     * @param repo
     * @return
     */
    def isActiveRepo(commit) {
        if (!all_repo_names) {throw new Exception('no repos')  }
          final Date LastPush = DatatypeConverter.parseDateTime(commit.committer.date).time
          int diff = new Date() - LastPush
        if (diff < 30l) return true else return false // active if comm1t happend within 30 day
            throw new Error("Timed out?")
    }


}

