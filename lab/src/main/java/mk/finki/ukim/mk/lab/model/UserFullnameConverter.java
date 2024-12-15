package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserFullnameConverter implements AttributeConverter<UserFullname,String> {

    @Override
    public String convertToDatabaseColumn(UserFullname userFullname) {
        if (userFullname == null) {
            return null;
        }
        return userFullname.getName() + " " + userFullname.getSurname();

    }

    @Override
    public UserFullname convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        String[] parts = dbData.split(" ");
        UserFullname fullname = new UserFullname();
        fullname.setName(parts[0]);
        fullname.setSurname(parts[1]);
        return fullname;
    }
}