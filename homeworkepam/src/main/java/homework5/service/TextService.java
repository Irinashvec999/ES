package homework5.service;

import homework5.domain.Text;

public interface TextService {
    Text convertStringToText(String text);
    String convertTextToString(Text text);
}
