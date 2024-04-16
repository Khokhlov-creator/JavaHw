package cz.cvut.fel.pjv;

public class BruteForceAttacker extends Thief {

    private boolean isOpened = false;


    @Override
    public void breakPassword(int sizeOfPwd) {
        char[] pwd = new char[sizeOfPwd];
        bruteForce(pwd, 0);
    }

    private void bruteForce(char[] pwd, int step) {
        if (isOpened) {
            return;
        }
        if (step == pwd.length) {
            isOpened = tryOpen(pwd);
            return;
        }

        int i;

        for (i = 0; i < getCharacters().length; i++) {
            char[] character = getCharacters();
            pwd[step] = character[i];
            bruteForce(pwd, step + 1);
        }

    }

}
