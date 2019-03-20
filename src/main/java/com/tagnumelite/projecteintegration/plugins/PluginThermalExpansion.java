package com.tagnumelite.projecteintegration.plugins;

import cofh.thermalexpansion.util.managers.machine.*;
import com.tagnumelite.projecteintegration.api.PEIPlugin;
import com.tagnumelite.projecteintegration.api.RegPEIPlugin;
import com.tagnumelite.projecteintegration.api.mappers.PEIMapper;
import net.minecraftforge.common.config.Configuration;

@SuppressWarnings("unused")
@RegPEIPlugin(modid = "thermalexpansion")
public class PluginThermalExpansion extends PEIPlugin {
	public PluginThermalExpansion(String modid, Configuration config) {
		super(modid, config);
	}

	@Override
	public void setup() {
		addMapper(new BrewerMapper());
		addMapper(new CentrifugeMapper());
		addMapper(new ChargerMapper());
		addMapper(new CompactorMapper());
		addMapper(new CrucibleMapper());
		addMapper(new EnchanterMapper());
		addMapper(new ExtruderMapper());
		addMapper(new FurnaceMapper());
		addMapper(new InsolatorMapper());
		addMapper(new PrecipitatorMapper());
		addMapper(new PulverizerMapper());
		addMapper(new RefineryMapper());
		addMapper(new SawmillMapper());
		addMapper(new SmelterMapper());
		addMapper(new TransposerMapper());

	}

	private class BrewerMapper extends PEIMapper {
		public BrewerMapper() {
			super("Brewer", "");
		}

		@Override
		public void setup() {
			for (BrewerManager.BrewerRecipe recipe : BrewerManager.getRecipeList()) {
				addRecipe(recipe.getOutputFluid(), recipe.getInput(), recipe.getInputFluid());
			}
		}
	}

	private class CentrifugeMapper extends PEIMapper {
		public CentrifugeMapper() {
			super("Centrifuge", "!!!TODO!!!");
		}

		@Override
		public void setup() {
			for (CentrifugeManager.CentrifugeRecipe recipe : CentrifugeManager.getRecipeList()) {
				// TODO: TODO
			}
		}
	}

	private class ChargerMapper extends PEIMapper {
		public ChargerMapper() {
			super("Charger", "");
		}

		@Override
		public void setup() {
			for (ChargerManager.ChargerRecipe recipe : ChargerManager.getRecipeList()) {
				addRecipe(recipe.getOutput(), recipe.getInput());
			}
		}
	}

	private class CompactorMapper extends PEIMapper {
		public CompactorMapper() {
			super("Compactor", "");
		}

		@Override
		public void setup() {
			for (CompactorManager.Mode mode : CompactorManager.Mode.values()) {
				for (CompactorManager.CompactorRecipe recipe : CompactorManager.getRecipeList(mode)) {
					addRecipe(recipe.getOutput(), recipe.getInput());
				}
			}
		}
	}

	private class CrucibleMapper extends PEIMapper {
		public CrucibleMapper() {
			super("Crucible", "");
		}

		@Override
		public void setup() {
			for (CrucibleManager.CrucibleRecipe recipe : CrucibleManager.getRecipeList()) {
				addRecipe(recipe.getOutput(), recipe.getInput());
			}
		}
	}

	private class EnchanterMapper extends PEIMapper {
		public EnchanterMapper() {
			super("Enchanter", "!!!TODO!!!");
		}

		@Override
		public void setup() {
			for (EnchanterManager.EnchanterRecipe recipe : EnchanterManager.getRecipeList()) {
				// TODO: TODO
			}
		}
	}

	private class ExtruderMapper extends PEIMapper {
		public ExtruderMapper() {
			super("Extruder", "");
		}

		private void addRecipe(ExtruderManager.ExtruderRecipe recipe) {
			addRecipe(recipe.getOutput(), recipe.getInputHot(), recipe.getInputCold());
		}

		@Override
		public void setup() {
			for (ExtruderManager.ExtruderRecipe recipe : ExtruderManager.getRecipeList(true)) {
				addRecipe(recipe);
			}

			for (ExtruderManager.ExtruderRecipe recipe : ExtruderManager.getRecipeList(false)) {
				addRecipe(recipe);
			}
		}
	}

	private class FurnaceMapper extends PEIMapper {
		public FurnaceMapper() {
			super("Furnace", "");
		}

		@Override
		public void setup() {
			for (FurnaceManager.FurnaceRecipe recipe : FurnaceManager.getRecipeList(false)) {
				addRecipe(recipe.getOutput(), recipe.getInput()); // TODO: FurnaceManager.getRecipeList(true)
			}
		}
	}

	private class InsolatorMapper extends PEIMapper {
		public InsolatorMapper() {
			super("Insolator", "!!!TODO!!!");
		}

		@Override
		public void setup() {
			for (InsolatorManager.InsolatorRecipe recipe : InsolatorManager.getRecipeList()) {
				// recipe.getType().STANDARD //TODO: TODO
			}
		}
	}

	private class PrecipitatorMapper extends PEIMapper {
		public PrecipitatorMapper() {
			super("Precipitator", "");
		}

		@Override
		public void setup() {
			for (PrecipitatorManager.PrecipitatorRecipe recipe : PrecipitatorManager.getRecipeList()) {
				addRecipe(recipe.getOutput(), recipe.getInput());
			}
		}
	}

	private class PulverizerMapper extends PEIMapper {
		public PulverizerMapper() {
			super("Pulverizer", "");
		}

		@Override
		public void setup() {
			for (PulverizerManager.PulverizerRecipe recipe : PulverizerManager.getRecipeList()) {
				addRecipe(recipe.getPrimaryOutput(), recipe.getInput()); // TODO: Maybe, the secondary outputs?
			}
		}
	}

	private class RefineryMapper extends PEIMapper {
		public RefineryMapper() {
			super("Refinery", "");
		}

		@Override
		public void setup() {
			for (RefineryManager.RefineryRecipe recipe : RefineryManager.getRecipeList()) {
				if (recipe.getChance() != 100)
					continue;

				addRecipe(recipe.getOutputItem(), recipe.getInput());
				addRecipe(recipe.getOutputFluid(), recipe.getInput()); // TODO: Combine this into one
			}
		}
	}

	private class SawmillMapper extends PEIMapper {
		public SawmillMapper() {
			super("Sawmill", "");
		}

		@Override
		public void setup() {
			for (SawmillManager.SawmillRecipe recipe : SawmillManager.getRecipeList()) {
				addRecipe(recipe.getPrimaryOutput(), recipe.getInput()); // TODO: Maybe the secondary outputs
			}
		}
	}

	private class SmelterMapper extends PEIMapper {
		public SmelterMapper() {
			super("Smelter", "");
		}

		@Override
		public void setup() {
			for (SmelterManager.SmelterRecipe recipe : SmelterManager.getRecipeList()) {
				addRecipe(recipe.getPrimaryOutput(), recipe.getPrimaryInput(), recipe.getSecondaryInput()); // TODO:
																											// Secondary
																											// Outputs
			}
		}
	}

	private class TransposerMapper extends PEIMapper {
		public TransposerMapper() {
			super("Transposer", "");
		}

		@Override
		public void setup() {
			for (TransposerManager.TransposerRecipe recipe : TransposerManager.getExtractRecipeList()) {
				// TODO: Need to figure this one out
			}

			for (TransposerManager.TransposerRecipe recipe : TransposerManager.getFillRecipeList()) {
				addRecipe(recipe.getOutput(), recipe.getInput(), recipe.getFluid());
			}
		}
	}
}