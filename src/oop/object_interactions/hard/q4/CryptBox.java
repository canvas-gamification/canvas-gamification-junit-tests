package oop.object_interactions.hard.q4;

public class CryptBox {
    private String lockedData;
    private int cryptKey;

    public CryptBox(String lockedData, int cryptKey) {
        this.lockedData = lockedData;
        this.cryptKey = cryptKey;
    }

    public int getCryptKey() {
        return cryptKey;
    }

    public String crossEncrypt(CryptBox second) {
        String result = "";
        for (int i = 0; i < lockedData.length(); i++)
            result += (char) (lockedData.charAt(i) + second.getCryptKey());
        return result;
    }
}

