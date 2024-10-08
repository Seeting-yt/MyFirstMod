package fr.dragonclaw.firstmod.items.customs;

import fr.dragonclaw.firstmod.utils.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item  {


    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if (!pContext.getLevel().isClientSide) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player p = pContext.getPlayer();

            boolean foundBlock = false;

            for (int i = 0; i<positionClicked.getY()+64; i++) {
                BlockState state  = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(state) && p != null) {
                    outPutValuableCoordinates(positionClicked.below(i), p, state.getBlock());
                    foundBlock = true;
                    break;
                }

            }

            if (!foundBlock && p != null) {
                p.sendSystemMessage(Component.literal("Aucun minerais n'a été trouvé !"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.mod1.metal_detector.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outPutValuableCoordinates(BlockPos ps, Player p, Block block) {
        p.sendSystemMessage(Component.literal("Un " + I18n.get(block.getDescriptionId()) +
                " a été trouvé aux coordonées " + ps.getX() + ", " + ps.getY() + ", " + ps.getZ()));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.METAL_DETECTOR_ORES);
    }
}
