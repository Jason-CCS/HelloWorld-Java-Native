package com.jason.dp;

import java.util.*;

/**
 * Problem: 139
 * Difficulty: Medium
 * The purpose of the problem is to solve the Word Break problem, which involves checking
 * if an input string can be segmented into space-separated sequence of one or more dictionary words.
 * The solution uses dynamic programming and a branch-and-bound approach.
 */
public class WordBreak {
    /**
     * This is really a branch and bound approach.
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        HashSet<String> whiteSet = new HashSet<>();
        HashSet<Tuple> blackSet = new HashSet<>();
        Deque<int[]> backtrackStack = new LinkedList<>();
        int start = 0, end = 1;
        boolean found = false;

        while (end <= len) {
            String word = s.substring(start, end);
            if (blackSet.contains(new Tuple(start, end))) {
                // failed path
                end = len;
            } else if (whiteSet.contains(word) || wordDict.contains(word)) {
                // possible path
                whiteSet.add(word);
                backtrackStack.push(new int[]{start, end});
                start = end;
                found = true;
            }
            end++;
            if (end > len) {
                if (found)
                    return found;
                else {
                    if (backtrackStack.isEmpty()) {
                        break;
                    } else {
                        int[] last = backtrackStack.pop();
                        start = last[0];
                        end = last[1];
                        blackSet.add(new Tuple(start, end));
                        end = end + 1;
                    }
                }
            }
            found = false;
        }

        return found;
    }

    static class Tuple {
        private final int start;
        private final int end;

        public Tuple(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // Override equals method
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return start == tuple.start && end == tuple.end;
        }

        // Override hashCode method
        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
//        System.out.println(wb.wordBreak("leetcode", new ArrayList<>(List.of("leet", "code"))));
//        System.out.println(wb.wordBreak("applepenapple", new ArrayList<>(List.of("apple", "pen", "apple"))));
//        System.out.println(wb.wordBreak("catsandog", new ArrayList<>(List.of("cats", "dog", "sand", "and", "cat"))));
//        System.out.println(wb.wordBreak("aaaaaaa", new ArrayList<>(List.of("aaaa", "aaa"))));
        System.out.println(wb.wordBreak("aaaaaaab", Arrays.asList("a", "aa", "aaa", "aaaa")));
        System.out.println(wb.wordBreak("catsandogcat", Arrays.asList("cats", "dog", "sand", "and", "cat", "an")));
        System.out.println(wb.wordBreak("catskicatcats", Arrays.asList("cats", "cat", "dog", "ski")));
        System.out.println(wb.wordBreak("fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami",
                Arrays.asList("kfomka", "hecagbngambii", "anobmnikj", "c", "nnkmfelneemfgcl", "ah",
                        "bgomgohl", "lcbjbg", "ebjfoiddndih", "hjknoamjbfhckb", "eioldlijmmla", "nbekmcnakif",
                        "fgahmihodolmhbi", "gnjfe", "hk", "b", "jbfgm", "ecojceoaejkkoed", "cemodhmbcmgl", "j",
                        "gdcnjj", "kolaijoicbc", "liibjjcini", "lmbenj", "eklingemgdjncaa", "m", "hkh", "fblb",
                        "fk", "nnfkfanaga", "eldjml", "iejn", "gbmjfdooeeko", "jafogijka", "ngnfggojmhclkjd",
                        "bfagnfclg", "imkeobcdidiifbm", "ogeo", "gicjog", "cjnibenelm", "ogoloc", "edciifkaff", "kbeeg",
                        "nebn", "jdd", "aeojhclmdn", "dilbhl", "dkk", "bgmck", "ohgkefkadonafg", "labem", "fheoglj",
                        "gkcanacfjfhogjc", "eglkcddd", "lelelihakeh", "hhjijfiodfi", "enehbibnhfjd", "gkm", "ggj",
                        "ag", "hhhjogk", "lllicdhihn", "goakjjnk", "lhbn", "fhheedadamlnedh", "bin", "cl", "ggjljjjf",
                        "fdcdaobhlhgj", "nijlf", "i", "gaemagobjfc", "dg", "g", "jhlelodgeekj", "hcimohlni", "fdoiohikhacgb",
                        "k", "doiaigclm", "bdfaoncbhfkdbjd", "f", "jaikbciac", "cjgadmfoodmba", "molokllh", "gfkngeebnggo",
                        "lahd", "n", "ehfngoc", "lejfcee", "kofhmoh", "cgda", "de", "kljnicikjeh", "edomdbibhif", "jehdkgmmofihdi",
                        "hifcjkloebel", "gcghgbemjege", "kobhhefbbb", "aaikgaolhllhlm", "akg", "kmmikgkhnn", "dnamfhaf",
                        "mjhj", "ifadcgmgjaa", "acnjehgkflgkd", "bjj", "maihjn", "ojakklhl", "ign", "jhd", "kndkhbebgh",
                        "amljjfeahcdlfdg", "fnboolobch", "gcclgcoaojc", "kfokbbkllmcd", "fec", "dljma", "noa", "cfjie",
                        "fohhemkka", "bfaldajf", "nbk", "kmbnjoalnhki", "ccieabbnlhbjmj", "nmacelialookal", "hdlefnbmgklo",
                        "bfbblofk", "doohocnadd", "klmed", "e", "hkkcmbljlojkghm", "jjiadlgf", "ogadjhambjikce",
                        "bglghjndlk", "gackokkbhj", "oofohdogb", "leiolllnjj", "edekdnibja", "gjhglilocif", "ccfnfjalchc",
                        "gl", "ihee", "cfgccdmecem", "mdmcdgjelhgk", "laboglchdhbk", "ajmiim", "cebhalkngloae",
                        "hgohednmkahdi", "ddiecjnkmgbbei", "ajaengmcdlbk", "kgg", "ndchkjdn", "heklaamafiomea", "ehg",
                        "imelcifnhkae", "hcgadilb", "elndjcodnhcc", "nkjd", "gjnfkogkjeobo", "eolega", "lm", "jddfkfbbbhia",
                        "cddmfeckheeo", "bfnmaalmjdb", "fbcg", "ko", "mojfj", "kk", "bbljjnnikdhg", "l", "calbc",
                        "mkekn", "ejlhdk", "hkebdiebecf", "emhelbbda", "mlba", "ckjmih", "odfacclfl", "lgfjjbgookmnoe",
                        "begnkogf", "gakojeblk", "bfflcmdko", "cfdclljcg", "ho", "fo", "acmi", "oemknmffgcio", "mlkhk",
                        "kfhkndmdojhidg", "ckfcibmnikn", "dgoecamdliaeeoa", "ocealkbbec", "kbmmihb", "ncikad", "hi",
                        "nccjbnldneijc", "hgiccigeehmdl", "dlfmjhmioa", "kmff", "gfhkd", "okiamg", "ekdbamm", "fc", "neg",
                        "cfmo", "ccgahikbbl", "khhoc", "elbg", "cbghbacjbfm", "jkagbmfgemjfg", "ijceidhhajmja", "imibemhdg",
                        "ja", "idkfd", "ndogdkjjkf", "fhic", "ooajkki", "fdnjhh", "ba", "jdlnidngkfffbmi", "jddjfnnjoidcnm",
                        "kghljjikbacd", "idllbbn", "d", "mgkajbnjedeiee", "fbllleanknmoomb", "lom", "kofjmmjm",
                        "mcdlbglonin", "gcnboanh", "fggii", "fdkbmic", "bbiln", "cdjcjhonjgiagkb", "kooenbeoongcle",
                        "cecnlfbaanckdkj", "fejlmog", "fanekdneoaammb", "maojbcegdamn", "bcmanmjdeabdo", "amloj",
                        "adgoej", "jh", "fhf", "cogdljlgek", "o", "joeiajlioggj", "oncal", "lbgg", "elainnbffk",
                        "hbdi", "femcanllndoh", "ke", "hmib", "nagfahhljh", "ibifdlfeechcbal", "knec", "oegfcghlgalcnno",
                        "abiefmjldmln", "mlfglgni", "jkofhjeb", "ifjbneblfldjel", "nahhcimkjhjgb", "cdgkbn",
                        "nnklfbeecgedie", "gmllmjbodhgllc", "hogollongjo", "fmoinacebll", "fkngbganmh", "jgdblmhlmfij",
                        "fkkdjknahamcfb", "aieakdokibj", "hddlcdiailhd", "iajhmg", "jenocgo", "embdib", "dghbmljjogka",
                        "bahcggjgmlf", "fb", "jldkcfom", "mfi", "kdkke", "odhbl", "jin", "kcjmkggcmnami", "kofig",
                        "bid", "ohnohi", "fcbojdgoaoa", "dj", "ifkbmbod", "dhdedohlghk", "nmkeakohicfdjf", "ahbifnnoaldgbj",
                        "egldeibiinoac", "iehfhjjjmil", "bmeimi", "ombngooicknel", "lfdkngobmik", "ifjcjkfnmgjcnmi",
                        "fmf", "aoeaa", "an", "ffgddcjblehhggo", "hijfdcchdilcl", "hacbaamkhblnkk", "najefebghcbkjfl",
                        "hcnnlogjfmmjcma", "njgcogemlnohl", "ihejh", "ej", "ofn", "ggcklj", "omah", "hg", "obk", "giig",
                        "cklna", "lihaiollfnem", "ionlnlhjckf", "cfdlijnmgjoebl", "dloehimen", "acggkacahfhkdne", "iecd",
                        "gn", "odgbnalk", "ahfhcd", "dghlag", "bchfe", "dldblmnbifnmlo", "cffhbijal", "dbddifnojfibha",
                        "mhh", "cjjol", "fed", "bhcnf", "ciiibbedklnnk", "ikniooicmm", "ejf", "ammeennkcdgbjco", "jmhmd",
                        "cek", "bjbhcmda", "kfjmhbf", "chjmmnea", "ifccifn", "naedmco", "iohchafbega", "kjejfhbco", "anlhhhhg")));
    }
}
