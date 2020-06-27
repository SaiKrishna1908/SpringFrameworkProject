package com.spring5.springserviceproject.Formatter;

import com.spring5.springserviceproject.Model.PetType;
import com.spring5.springserviceproject.Service.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class PetTypeFormatter  implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> petTypes = petTypeService.findAll();
        for(PetType type : petTypes){
            if(type.getName().equals(text))
                return type;
        }

        throw  new ParseException("type not found "+text,0);
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }


}
