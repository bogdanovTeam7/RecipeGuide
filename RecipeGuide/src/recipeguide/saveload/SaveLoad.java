package recipeguide.saveload;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import recipeguide.settings.Settings;

public class SaveLoad {

	public static void load(SaveData saveData) {
		try {
			JAXBContext context = JAXBContext.newInstance(Wrapper.class);
			Unmarshaller um = context.createUnmarshaller();
			Wrapper wrapper = (Wrapper) um.unmarshal(Settings.getFileSave());

			saveData.setCategories(wrapper.getCategories());
			saveData.setIngredients(wrapper.getIngredients());
			saveData.setRecipes(wrapper.getRecipes());
			saveData.setTypes(wrapper.getTypes());
			saveData.setUnits(wrapper.getUnits());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static void save(SaveData saveData) {
		try {
			JAXBContext context = JAXBContext.newInstance(Wrapper.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Wrapper wrapper = new Wrapper();
			wrapper.setCategories(saveData.getCategories());
			wrapper.setIngredients(saveData.getIngredients());
			wrapper.setRecipes(saveData.getRecipes());
			wrapper.setTypes(saveData.getTypes());
			wrapper.setUnits(saveData.getUnits());

			marshaller.marshal(wrapper, Settings.getFileSave());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
