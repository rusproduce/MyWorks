import java.util.*;

public class YandexN3 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String n = scanner.nextLine();
//        String input = scanner.nextLine();
//        System.out.println(counting3(input, Integer.parseInt(n)));

        System.out.println(counting3("tttt tttt ttt tttt ttt", 0));
//        System.out.println(counting3("hello world hello", 0));
//        System.out.println(counting3("an apple a big apple", 0));
//        System.out.println(counting3("aaaaa aaaab aaaaa abaaa abaaa", 0));

    }

    public static int counting(String input, int numberOfWords) {
        String[] words = input.split(" ");
        int count = words[0].length();
        String part = " " + words[0] + " ";
        for (int i = 1; i < numberOfWords; i++) {
            if (words[i].length() != 1 && part.contains(" " + words[i] + " ")) {
                String wordPart = words[i].substring(0, words[i].length() - 1);
                String partCheck = part.replaceAll(" " + words[i] + " ", " ");
                if (partCheck.replaceFirst(wordPart + "(\\w+)? ", "").equals(partCheck)) {
                    for (int j = 1; j < words[i].length(); j++) {
                        if (!partCheck.contains(" " + words[i].substring(0, j))) {
                            count += j;
                            break;
                        }
                    }
                } else {
                    count += words[i].length();
                }
            } else {
                count += words[i].length();
            }
            part += " " + words[i] + " ";
        }
        return count;
    }

    public static int counting2(String input, int numberOfWords) {
        int result = 0;
        Set<String> dict = new TreeSet<>();
        List<String> words = Arrays.asList(input.split(" "));
        for (String word : words) {
            String wordPath2 = word.substring(0, word.length() - 1);
            if (!dict.contains(word)) {
                dict.add(word);
                result += word.length();
            } else if (dict.stream().filter(ee -> !ee.equals(word)).anyMatch(e -> e.startsWith(wordPath2))) {
                result += word.length();
            } else {
                for (int i = 1; i <= word.length(); i++) {
                    String wordPath = word.substring(0, i);
                    if (dict.stream().filter(ee -> !ee.equals(word)).noneMatch(e -> e.startsWith(wordPath))) {
                        result += i;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static int counting3(String input, int numberOfWords) {
        int result = 0;
        Set<Dict> dictSet = new HashSet<>();
        List<String> words = Arrays.asList(input.split(" "));
        for (String word : words) {
            Dict dict = dictSet.stream().filter(e -> e.getWord().equals(word)).findFirst().orElse(null);
            if (dict == null) {
                add(dictSet, word);
                result += word.length();
            } else {
                result += dict.getN();
            }
        }
        return result;
    }

    public static void add(Set<Dict> dictSet, String word) {
        int n = 1;
        for (Dict dict : dictSet) {
            for (int i = 1; i <= word.length(); ) {
                if (!dict.getWord().startsWith(word.substring(0, i))) {
                    break;
                } else {
                    i++;
                    if (n < i && word.length() >= i) n = i;
                    if (dict.getN() < i) {
                        if (dict.getWord().length() >= i) dict.setN(i);
                        else break;
                    }
                }
            }
        }
        dictSet.add(new Dict(word, n));
    }

    public static class Dict {
        public Dict(String word, int n) {
            this.word = word;
            this.n = n;
        }

        private String word;
        private int n;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

    }
}