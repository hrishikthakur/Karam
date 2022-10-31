public static boolean canPlaceHlly(int r, int c, char[][] crossword, String word){
    if(c - 1 >= 0 && crossword[r][c - 1] != '+') return false;
    else if(c + word.length() < crossword[0].length && crossword[r][c + word.length()] != '+') return false;

    for(int i = 0; i < word.length(); i++){
        if(c + i == crossword[0].length) return false;

        int ourCh = word.charAt(i);
        int boardCh = crossword[r][c + i];
      //   if(boardCh != ourCh || boardCh != '-') return false;
        if(boardCh == '+' || (ourCh != boardCh && boardCh != '-')) return false;
    }
    return true;
}

public static boolean canPlaceVlly(int r, int c, char[][] crossword, String word){
    if(r - 1 >= 0 && crossword[r - 1][c] != '+') return false;
    else if(r + word.length() < crossword.length && crossword[r + word.length()][c] != '+') return false;

    for(int i = 0; i < word.length(); i++){
        if(r + i == crossword.length) return false;

        int ourCh = word.charAt(i);
        int boardCh = crossword[r + i][c];
      //   if(ourCh != boardCh || boardCh != '-') return false;
      if(boardCh == '+' || (ourCh != boardCh && boardCh != '-')) return false;
    }
    return true;
}

public static String placeHlly(int r, int c, char[][] crossword, String word){
    String oldWord = "";
    for(int j = 0; j < word.length(); j++){
        oldWord += crossword[r][c + j];
        crossword[r][c + j] = word.charAt(j);
    }
    return oldWord;
}

public static String placeVlly(int r, int c, char[][] crossword, String word){
    String oldWord = "";
    for(int i = 0; i < word.length(); i++){
        oldWord += crossword[r + i][c];
        crossword[r + i][c] = word.charAt(i);
    }
    return oldWord;
}

public static void solveCrossword(char[][] crossword, String[] words, int vidx) {
    if(vidx == words.length){
        print(crossword);
        return;
    }

    for(int i = 0; i < crossword.length; i++){
        for(int j = 0; j < crossword[0].length; j++){
            if(crossword[i][j] == '-' || crossword[i][j] == words[vidx].charAt(0)){

                if(canPlaceHlly(i, j, crossword, words[vidx])){
                    String oldWord = placeHlly(i, j, crossword, words[vidx]);
                    solveCrossword(crossword, words, vidx + 1);
                    placeHlly(i, j, crossword, oldWord);
                }

                if(canPlaceVlly(i, j, crossword, words[vidx])){
                    String oldWord = placeVlly(i, j, crossword, words[vidx]);
                    solveCrossword(crossword, words, vidx + 1);
                    placeVlly(i, j, crossword, oldWord);
                }
            }
        }
    }
}
