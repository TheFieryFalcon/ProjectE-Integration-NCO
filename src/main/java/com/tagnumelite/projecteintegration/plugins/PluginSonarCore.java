package com.tagnumelite.projecteintegration.plugins;

import java.util.ArrayList;
import java.util.List;
import com.tagnumelite.projecteintegration.api.mappers.PEIMapper;

import sonar.core.recipes.DefaultSonarRecipe;
import sonar.core.recipes.ISonarRecipeObject;

public class PluginSonarCore {
	public static abstract class SonarMapper extends PEIMapper {
		public SonarMapper(String name) {
			super(name);
		}
		
		public SonarMapper(String name, String description) {
			super(name, description);
		}

		protected void addRecipe(DefaultSonarRecipe recipe) {
			List<Object> inputs = new ArrayList<>();

			for (ISonarRecipeObject input : recipe.inputs()) {
				if (input.getJEIValue().size() == 1)
					inputs.add(input.getJEIValue().get(0));
				else
					inputs.add(input.getJEIValue());
			}
			
			ArrayList<Object> outputs = new ArrayList<>();
			
			for (ISonarRecipeObject out : recipe.outputs()) {
				outputs.addAll(out.getJEIValue());
				/*for (ItemStack output : out.getJEIValue()) {
					addRecipe(output, inputs.stream().toArray());

				}*/
			}
			
			addRecipe(outputs, inputs.stream().toArray());
		}
	}
}
