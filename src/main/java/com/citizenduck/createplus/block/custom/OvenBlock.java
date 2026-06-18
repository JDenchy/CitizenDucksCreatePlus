package com.citizenduck.createplus.block.custom;

import com.citizenduck.createplus.sound.ModSounds;
import com.citizenduck.createplus.utility.MathUtils;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FireChargeItem;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.Tags;

import javax.annotation.Nullable;

public class OvenBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING;
    public static final BooleanProperty LIT;

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        LIT = BlockStateProperties.LIT;
    }

    public static final MapCodec<OvenBlock> CODEC = simpleCodec(OvenBlock::new);

    public MapCodec<OvenBlock> codec() {
        return CODEC;
    }

    public OvenBlock(Properties properties) {
        super(properties);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
        builder.add(new Property[]{LIT});
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(LIT, false);
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (state.getValue(LIT)) {
            var extinguishResult = tryToExtinguish(heldStack, state, level, pos, player, hand, hit);
            if (extinguishResult != ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION) return extinguishResult;
        } else {
            var igniteResult = tryToIgnite(heldStack, state, level, pos, player, hand, hit);
            if (igniteResult != ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION) return igniteResult;
        }

        return tryToPlaceFoodItem(heldStack, state, level, pos, player, hand, hit);
    }

    protected ItemInteractionResult tryToIgnite(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        Item heldItem = heldStack.getItem();

        if (heldItem instanceof FlintAndSteelItem) {
            if (!level.isClientSide()) {
                level.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, MathUtils.RAND.nextFloat() * 0.4F + 0.8F);
            }
            ignite(null, level, pos, state);
            heldStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            return ItemInteractionResult.SUCCESS;
        }

        if (heldItem instanceof FireChargeItem) {
            if (!level.isClientSide()) {
                level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, (MathUtils.RAND.nextFloat() - MathUtils.RAND.nextFloat()) * 0.2F + 1.0F);
            }
            ignite(null, level, pos, state);
            if (!player.getAbilities().instabuild) {
                heldStack.shrink(1);
            }
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected ItemInteractionResult tryToExtinguish(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (heldStack.canPerformAction(ItemAbilities.SHOVEL_DIG)) {
            if (!level.isClientSide()) {
                level.levelEvent(null, LevelEvent.SOUND_EXTINGUISH_FIRE, pos, 0);
            }
            extinguish(null, level, pos, state);
            heldStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            return ItemInteractionResult.sidedSuccess(level.isClientSide());
        }

        if (heldStack.is(Tags.Items.BUCKETS_WATER)) {
            if (!level.isClientSide()) {
                level.playSound(null, pos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            extinguish(null, level, pos, state);
            if (!player.getAbilities().instabuild) player.setItemInHand(hand, heldStack.getCraftingRemainingItem());
            return ItemInteractionResult.sidedSuccess(level.isClientSide());
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public void ignite(@Nullable Entity entity, LevelAccessor level, BlockPos pos, BlockState state) {

        var newState = state.setValue(LIT, true);
        level.setBlock(pos, newState, 11);
        level.gameEvent(entity, GameEvent.BLOCK_CHANGE, pos);
    }

    public void extinguish(@Nullable Entity entity, LevelAccessor level, BlockPos pos, BlockState state) {

        var newState = state.setValue(LIT, false);
        level.setBlock(pos, newState, 11);
        level.gameEvent(entity, GameEvent.BLOCK_CHANGE, pos);
    }

    protected  ItemInteractionResult tryToPlaceFoodItem(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (!state.getValue(LIT)) return;
        double x = (double) pos.getX() + 0.5D;
        double y = pos.getY();
        double z = (double) pos.getZ() + 0.5D;
        if (random.nextInt(10) == 0) {
            level.playLocalSound(x, y, z, ModSounds.BLOCK_OVEN_CRACKLE.get(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
        }

        Direction direction = state.getValue(HorizontalDirectionalBlock.FACING);
        Direction.Axis direction$axis = direction.getAxis();
        double horizontalOffset = random.nextDouble() * 0.6D - 0.3D;
        double xOffset = direction$axis == Direction.Axis.X ? (double) direction.getStepX() * 0.52D : horizontalOffset;
        double yOffset = random.nextDouble() * 6.0D / 16.0D;
        double zOffset = direction$axis == Direction.Axis.Z ? (double) direction.getStepZ() * 0.52D : horizontalOffset;
        level.addParticle(ParticleTypes.SMOKE, x + xOffset, y + yOffset, z + zOffset, 0.0D, 0.0D, 0.0D);
        level.addParticle(ParticleTypes.FLAME, x + xOffset, y + yOffset, z + zOffset, 0.0D, 0.0D, 0.0D);
    }
}
