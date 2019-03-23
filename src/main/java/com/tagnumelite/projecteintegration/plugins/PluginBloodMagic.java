package com.tagnumelite.projecteintegration.plugins;

import com.tagnumelite.projecteintegration.api.PEIPlugin;
import com.tagnumelite.projecteintegration.api.RegPEIPlugin;
import com.tagnumelite.projecteintegration.api.mappers.PEIMapper;

import WayofTime.bloodmagic.api.impl.BloodMagicAPI;
import WayofTime.bloodmagic.api.impl.recipe.RecipeAlchemyArray;
import WayofTime.bloodmagic.api.impl.recipe.RecipeAlchemyTable;
import WayofTime.bloodmagic.api.impl.recipe.RecipeBloodAltar;
import WayofTime.bloodmagic.api.impl.recipe.RecipeTartaricForge;
import net.minecraftforge.common.config.Configuration;

@RegPEIPlugin(modid = "bloodmagic")
public class PluginBloodMagic extends PEIPlugin {
	public PluginBloodMagic(String modid, Configuration config) {
		super(modid, config);
	}

	@Override
	public void setup() {
		addMapper(new AlchemyArrayMapper());
		addMapper(new AlchemyTableMapper());
		addMapper(new BloodAltarMapper());
		addMapper(new TartaricForgeMapper());
	}

	private class AlchemyArrayMapper extends PEIMapper {
		public AlchemyArrayMapper() {
			super("Alchemy Array", "");
		}

		@Override
		public void setup() {
			for (RecipeAlchemyArray recipe : BloodMagicAPI.INSTANCE.getRecipeRegistrar().getAlchemyArrayRecipes()) {
				addRecipe(recipe.getOutput(), recipe.getCatalyst(), recipe.getInput());
			}
		}
	}

	private class AlchemyTableMapper extends PEIMapper {
		public AlchemyTableMapper() {
			super("Alchemy Table", "");
		}

		@Override
		public void setup() {
			for (RecipeAlchemyTable recipe : BloodMagicAPI.INSTANCE.getRecipeRegistrar().getAlchemyRecipes()) {
				addRecipe(recipe.getOutput(), recipe.getInput().toArray()); //TODO: Add EMC to ... something?
			}
		}
	}

	private class BloodAltarMapper extends PEIMapper {
		public BloodAltarMapper() {
			super("Blood Altar", "");
		}

		@Override
		public void setup() {
			for (RecipeBloodAltar recipe : BloodMagicAPI.INSTANCE.getRecipeRegistrar().getAltarRecipes()) {
				addRecipe(recipe.getOutput(), recipe.getInput()); //TODO: Add EMC to blood
			}
		}
	}

	private class TartaricForgeMapper extends PEIMapper {
		public TartaricForgeMapper() {
			super("Tartaric Forge", "");
		}

		@Override
		public void setup() {
			for (RecipeTartaricForge recipe : BloodMagicAPI.INSTANCE.getRecipeRegistrar().getTartaricForgeRecipes()) {
				addRecipe(recipe.getOutput(), recipe.getInput().toArray()); //TODO: Add EMC to Souls
			}
		}
	}
}
