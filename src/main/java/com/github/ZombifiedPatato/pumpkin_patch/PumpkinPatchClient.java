package com.github.ZombifiedPatato.pumpkin_patch;

import com.github.ZombifiedPatato.pumpkin_patch.entity.ModEntities;
import com.github.ZombifiedPatato.pumpkin_patch.entity.client.FairyPowderRenderer;
import com.github.ZombifiedPatato.pumpkin_patch.particle.custom.DragonBreathParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.particle.CampfireSmokeParticle;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import com.github.ZombifiedPatato.pumpkin_patch.entity.client.DwarvenDynamiteRenderer;
import com.github.ZombifiedPatato.pumpkin_patch.particle.ModParticles;

@Environment(EnvType.CLIENT)
public class PumpkinPatchClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        EntityRendererRegistry.register(ModEntities.FAIRY_POWDER, FairyPowderRenderer::new);
        EntityRendererRegistry.register(ModEntities.DWARVEN_DYNAMITE, DwarvenDynamiteRenderer::new);

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((((atlasTexture, registry) ->
                registry.register(new Identifier(PumpkinPatch.MOD_ID, "particle/pink_smoke")))));
        ParticleFactoryRegistry.getInstance().register(ModParticles.PINK_SMOKE, CampfireSmokeParticle.CosySmokeFactory::new);


        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_DRAGON_BREATH, DragonBreathParticle.RedFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GREEN_DRAGON_BREATH, DragonBreathParticle.GreenFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLUE_DRAGON_BREATH, DragonBreathParticle.BlueFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLACK_DRAGON_BREATH, DragonBreathParticle.BlackFactory::new);
    }

}
