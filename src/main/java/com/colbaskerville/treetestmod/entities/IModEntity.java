package com.colbaskerville.treetestmod.entities;

import net.minecraft.nbt.NBTTagCompound;

// TODO: Auto-generated Javadoc
/**
 * This interface is intended to help identify entities from this mob and enforce consistent behavior where desired across them.
 * 
 * @author jabelar
 *
 */
public interface IModEntity
{

    /**
     * Setup AI.
     */
    // set up AI tasks
    void setupAI();

    /**
     * Clear AI tasks.
     */
    // use clear tasks for subclasses then build up their ai task list specifically
    void clearAITasks();

    /**
     * Inits the sync data compound.
     */
    // initialize the tag compound used for syncing custom entity data
    void initSyncDataCompound();

    /**
     * Gets the sync data compound.
     *
     * @return the sync data compound
     */
    NBTTagCompound getSyncDataCompound();

    /**
     * Sets the sync data compound.
     *
     * @param parCompound
     *            the new sync data compound
     */
    void setSyncDataCompound(NBTTagCompound parCompound);

    /**
     * Send entity sync packet.
     */
    // method to send sync of extended properties from server to clients
    void sendEntitySyncPacket();

    /**
     * Sets the scale factor.
     *
     * @param parScaleFactor
     *            the new scale factor
     */
    // common encapsulation methods
    void setScaleFactor(float parScaleFactor);

    /**
     * Gets the scale factor.
     *
     * @return the scale factor
     */
    float getScaleFactor();

}
