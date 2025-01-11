package me.rubyboat.goathorn.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import de.maxhenkel.voicechat.voice.server.Server;
import me.rubyboat.goathorn.GoatHornSpeechAmplifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Server.class)
@Environment(EnvType.SERVER)
public class VoiceChatServerMixin {
    @ModifyVariable(method = "processProximityPacket", at = @At("STORE"), ordinal = 3)
    private float modifyMultiplier(float multiplier, @Local(argsOnly = true) ServerPlayerEntity sender) {
        if(sender.getStackInHand(Hand.MAIN_HAND).isOf(Items.GOAT_HORN) || sender.getStackInHand(Hand.OFF_HAND).isOf(Items.GOAT_HORN)) {
            return multiplier * sender.server.getGameRules().getInt(GoatHornSpeechAmplifier.GOAT_HORN_AMPLIFIER);
        }
        return multiplier;
    }
}
