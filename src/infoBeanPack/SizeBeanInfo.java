package infoBeanPack;

import java.awt.Dimension;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;
import java.lang.reflect.Method;

import component.OwnCompPanel;

import editor.ProperEditor;

public class SizeBeanInfo extends SimpleBeanInfo {

	public PropertyDescriptor sizePropertyDescriptor()
			throws NoSuchMethodException, SecurityException,
			IntrospectionException {

		Class aGetMethodParameterTypes[] = {};

		Method aGetMethod = getClass().getMethod("getSize",
				aGetMethodParameterTypes);

		Class aSetMethodParameterTypes = Dimension.class;

		Method aSetMethod =

		getClass().getMethod("setSize",

		aSetMethodParameterTypes);

		PropertyDescriptor aDescriptor =

		new PropertyDescriptor("size", aGetMethod, aSetMethod);

		aDescriptor.setPropertyEditorClass(OwnCompPanel.class);

		return aDescriptor;

	}

	public PropertyDescriptor[] getPropertyDescriptors() {

		PropertyDescriptor[] aDescriptorList = new PropertyDescriptor[1];
		try {
			aDescriptorList[0] = sizePropertyDescriptor();
		} catch (NoSuchMethodException | SecurityException
				| IntrospectionException e) {
			e.printStackTrace();
		}

		return aDescriptorList;

	}
}
