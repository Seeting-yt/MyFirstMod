package fr.dragonclaw.firstmod.blocks.customs;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ExplosiveBlock extends Block {
    // Drapeau pour éviter les explosions en boucle
    private boolean isExploding = false;

    public ExplosiveBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (!this.isExploding)
             triggerExplosion(pLevel, pPos);

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.mod1.explosive_block.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }

    // Méthode pour déclencher une explosion
    private void triggerExplosion(Level level, BlockPos pos) {
        // Active le drapeau pour indiquer que le bloc est en train d'exploser
        this.isExploding = true;
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 3.0F, true,
                Level.ExplosionInteraction.BLOCK);
        // Désactive le drapeau après l'explosion
        this.isExploding = false;
    }
}

