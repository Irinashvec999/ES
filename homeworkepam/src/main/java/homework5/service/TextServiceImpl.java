package homework5.service;

import homework5.domain.Text;

public class TextServiceImpl implements TextService {
    @Override
    public Text convertStringToText(String text) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public String convertTextToString(Text text) {
        return text == null ? null : text.toString();
    }
}
