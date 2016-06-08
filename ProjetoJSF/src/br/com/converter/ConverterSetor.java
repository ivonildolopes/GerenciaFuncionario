package br.com.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.JPA.EntityManagerUtil;
import br.com.modelo.Setor;

@FacesConverter(value = "converterSetor")
public class ConverterSetor implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String str) {

		if (str.equals("") || str.equals("Selecione um Setor")) {
			return null;
		}

		return EntityManagerUtil.getEntityManager().find(Setor.class,
				Integer.parseInt(str));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if (obj == null)
			return null;

		Setor setor = (Setor) obj;
		return setor.getId().toString();

	}

}
