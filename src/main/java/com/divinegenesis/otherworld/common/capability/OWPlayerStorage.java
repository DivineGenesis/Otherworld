package com.divinegenesis.otherworld.common.capability;

public class OWPlayerStorage implements IOWPlayerStorage
{
    protected boolean soul;

    OWPlayerStorage()
    {
        soul = true;
    }

    @Override
    public boolean hasSoul() { return soul; }

    @Override
    public void setSoul(boolean soul_determiner) {
        soul = soul_determiner;
    }
}
