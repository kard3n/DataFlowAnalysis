package org.dataflowanalysis.analysis.dfd.core;

import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.dfd.datadictionary.AbstractLabel;
import org.dataflowanalysis.dfd.datadictionary.AbstractLabelType;

/**
 * This class represents a characteristic value in a dfd model
 * @param labelType Label type model object of the characteristic value
 * @param label Label model object of the characteristic value
 */
public record DFDCharacteristicValue(AbstractLabelType labelType, AbstractLabel label) implements CharacteristicValue {

    @Override
    public String getTypeName() {
        return this.labelType()
                .getEntityName();
    }

    @Override
    public String getValueName() {
        return this.label()
                .getEntityName();
    }

    @Override
    public String getValueId() {
        return this.label()
                .getId();
    }

    /**
     * Returns the label stored in the Characteristics Value
     * @return Label
     */
    public AbstractLabel getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return String.format("%s.%s", this.getTypeName(), this.getValueName());
    }
}
