package me.rubyboat.goathorn;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoatHornSpeechAmplifier implements ModInitializer {
	public static final GameRules.Key<GameRules.IntRule> GOAT_HORN_AMPLIFIER =
			GameRuleRegistry.register("goatHornAmplifier", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(3, 1, Integer.MAX_VALUE));

	@Override
	public void onInitialize() {
	}
}