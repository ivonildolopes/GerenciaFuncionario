package br.com.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converterDate")
public class ConverterDate implements Converter {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String str) {
		//Calendar c = Calendar.getInstance();
		Date d = new Date();
		sdf.setLenient(false);
		
		try{
			//d.setTime(sdf.parse(str));
			sdf.format(d);
			//d.parse(str);
		}catch(Exception e){
			return null;
		}
		return d;
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		//Calendar c = (Calendar) obj;
		Date d = (Date) obj;
		String str = sdf.format(d.getTime());
		
		return str;

	}

}
