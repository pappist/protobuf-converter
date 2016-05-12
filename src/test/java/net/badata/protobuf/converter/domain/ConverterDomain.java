package net.badata.protobuf.converter.domain;

import net.badata.protobuf.converter.proto.ConverterProto;
import net.badata.protobuf.converter.annotation.ProtoClass;
import net.badata.protobuf.converter.annotation.ProtoField;
import net.badata.protobuf.converter.inspection.DefaultValue;
import net.badata.protobuf.converter.inspection.NullValueInspector;
import net.badata.protobuf.converter.type.DateLongConverterImpl;
import net.badata.protobuf.converter.type.EnumStringConverter;
import net.badata.protobuf.converter.type.SetListConverterImpl;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by jsjem on 26.04.2016.
 */
public class ConverterDomain {

	@ProtoClass(ConverterProto.ConverterTest.class)
	public static class Test {

		@ProtoField
		private Long longValue;
		@ProtoField
		private Integer intValue;
		@ProtoField
		private Float floatValue;
		@ProtoField
		private Double doubleValue;
		@ProtoField(name = "booleanValue")
		private Boolean boolValue;
		@ProtoField
		private String stringValue;
		@ProtoField
		private PrimitiveTest primitiveValue;
		@ProtoField
		private FieldConverterTest fieldConversionValue;
		@ProtoField
		private NullDefaultTest nullDefaultValue;
		@ProtoField(name = "stringListValue")
		private List<String> simpleListValue;
		@ProtoField
		private List<PrimitiveTest> complexListValue;


		public Long getLongValue() {
			return longValue;
		}

		public void setLongValue(final Long longValue) {
			this.longValue = longValue;
		}

		public Integer getIntValue() {
			return intValue;
		}

		public void setIntValue(final Integer intValue) {
			this.intValue = intValue;
		}

		public Float getFloatValue() {
			return floatValue;
		}

		public void setFloatValue(final Float floatValue) {
			this.floatValue = floatValue;
		}

		public Double getDoubleValue() {
			return doubleValue;
		}

		public void setDoubleValue(final Double doubleValue) {
			this.doubleValue = doubleValue;
		}

		public Boolean getBoolValue() {
			return boolValue;
		}

		public void setBoolValue(final Boolean boolValue) {
			this.boolValue = boolValue;
		}

		public String getStringValue() {
			return stringValue;
		}

		public void setStringValue(final String stringValue) {
			this.stringValue = stringValue;
		}

		public PrimitiveTest getPrimitiveValue() {
			return primitiveValue;
		}

		public void setPrimitiveValue(final PrimitiveTest primitiveValue) {
			this.primitiveValue = primitiveValue;
		}

		public FieldConverterTest getFieldConversionValue() {
			return fieldConversionValue;
		}

		public void setFieldConversionValue(final FieldConverterTest fieldConversionValue) {
			this.fieldConversionValue = fieldConversionValue;
		}

		public NullDefaultTest getNullDefaultValue() {
			return nullDefaultValue;
		}

		public void setNullDefaultValue(final NullDefaultTest nullDefaultValue) {
			this.nullDefaultValue = nullDefaultValue;
		}

		public List<String> getSimpleListValue() {
			return simpleListValue;
		}

		public void setSimpleListValue(final List<String> simpleListValue) {
			this.simpleListValue = simpleListValue;
		}


		public List<PrimitiveTest> getComplexListValue() {
			return complexListValue;
		}

		public void setComplexListValue(final List<PrimitiveTest> complexListValue) {
			this.complexListValue = complexListValue;
		}
	}

	@ProtoClass(ConverterProto.PrimitiveTest.class)
	public static class PrimitiveTest {

		@ProtoField
		private long longValue;
		@ProtoField
		private int intValue;
		@ProtoField
		private float floatValue;
		@ProtoField
		private double doubleValue;
		@ProtoField
		private boolean booleanValue;

		public long getLongValue() {
			return longValue;
		}

		public void setLongValue(final long longValue) {
			this.longValue = longValue;
		}

		public int getIntValue() {
			return intValue;
		}

		public void setIntValue(final int intValue) {
			this.intValue = intValue;
		}

		public float getFloatValue() {
			return floatValue;
		}

		public void setFloatValue(final float floatValue) {
			this.floatValue = floatValue;
		}

		public double getDoubleValue() {
			return doubleValue;
		}

		public void setDoubleValue(final double doubleValue) {
			this.doubleValue = doubleValue;
		}

		public boolean isBooleanValue() {
			return booleanValue;
		}

		public void setBooleanValue(final boolean booleanValue) {
			this.booleanValue = booleanValue;
		}
	}

	@ProtoClass(ConverterProto.FieldConverterTest.class)
	public static class FieldConverterTest {

		@ProtoField(converter = TestEnumConverter.class)
		private TestEnumConverter.TestEnum enumString;
		@ProtoField(converter = DateLongConverterImpl.class)
		private Date dateLong;
		@ProtoField(converter = SetListConverterImpl.class)
		private Set<String> stringSetValue;


		public TestEnumConverter.TestEnum getEnumString() {
			return enumString;
		}

		public void setEnumString(final TestEnumConverter.TestEnum enumString) {
			this.enumString = enumString;
		}

		public Date getDateLong() {
			return dateLong;
		}

		public void setDateLong(final Date dateLong) {
			this.dateLong = dateLong;
		}

		public Set<String> getStringSetValue() {
			return stringSetValue;
		}

		public void setStringSetValue(final Set<String> stringSetValue) {
			this.stringSetValue = stringSetValue;
		}
	}

	public static class TestEnumConverter extends EnumStringConverter<TestEnumConverter.TestEnum> {

		public static enum TestEnum {
			ONE, TWO, THREE;
		}
	}

	@ProtoClass(ConverterProto.NullDefaultTest.class)
	public static class NullDefaultTest {
		@ProtoField
		private String nullString;
		@ProtoField(nullValue = AlwaysNullInspector.class, defaultValue = StringDefaultValue.class)
		private String customInspectionString;
		@ProtoField
		private PrimitiveWrapperTest defaultPrimitives;


		public String getNullString() {
			return nullString;
		}

		public void setNullString(final String nullString) {
			this.nullString = nullString;
		}

		public String getCustomInspectionString() {
			return customInspectionString;
		}

		public void setCustomInspectionString(final String customInspectionString) {
			this.customInspectionString = customInspectionString;
		}

		public PrimitiveWrapperTest getDefaultPrimitives() {
			return defaultPrimitives;
		}

		public void setDefaultPrimitives(final PrimitiveWrapperTest defaultPrimitives) {
			this.defaultPrimitives = defaultPrimitives;
		}
	}

	@ProtoClass(ConverterProto.PrimitiveTest.class)
	public static class PrimitiveWrapperTest {

		@ProtoField
		private Long longValue;
		@ProtoField
		private Integer intValue;
		@ProtoField
		private Float floatValue;
		@ProtoField
		private Double doubleValue;
		@ProtoField
		private Boolean booleanValue;

		public Long getLongValue() {
			return longValue;
		}

		public void setLongValue(final Long longValue) {
			this.longValue = longValue;
		}

		public Integer getIntValue() {
			return intValue;
		}

		public void setIntValue(final Integer intValue) {
			this.intValue = intValue;
		}

		public Float getFloatValue() {
			return floatValue;
		}

		public void setFloatValue(final Float floatValue) {
			this.floatValue = floatValue;
		}

		public Double getDoubleValue() {
			return doubleValue;
		}

		public void setDoubleValue(final Double doubleValue) {
			this.doubleValue = doubleValue;
		}

		public Boolean getBooleanValue() {
			return booleanValue;
		}

		public void setBooleanValue(final Boolean booleanValue) {
			this.booleanValue = booleanValue;
		}
	}

	public static class AlwaysNullInspector implements NullValueInspector {

		@Override
		public boolean isNull(final Object value) {
			return true;
		}
	}

	public static class StringDefaultValue implements DefaultValue {

		@Override
		public Object generateValue(final Class<?> type) {
			return "Custom default";
		}
	}
}