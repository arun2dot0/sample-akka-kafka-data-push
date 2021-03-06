/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package akka.kafka.example.datapush.avro.schema;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class EmployeeSchema extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EmployeeSchema\",\"namespace\":\"akka.kafka.example.datapush.avro.schema\",\"fields\":[{\"name\":\"Id\",\"type\":\"long\"},{\"name\":\"firstName\",\"type\":\"string\"},{\"name\":\"lastName\",\"type\":\"string\"},{\"name\":\"title\",\"type\":\"string\"},{\"name\":\"createdDate\",\"type\":\"string\",\"java-class\":\"java.util.Date\"},{\"name\":\"modifiedDate\",\"type\":\"string\",\"java-class\":\"java.util.Date\"}],\"doc:\":\"Schema for Employee\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public long Id;
  @Deprecated public java.lang.CharSequence firstName;
  @Deprecated public java.lang.CharSequence lastName;
  @Deprecated public java.lang.CharSequence title;
  @Deprecated public java.lang.CharSequence createdDate;
  @Deprecated public java.lang.CharSequence modifiedDate;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public EmployeeSchema() {}

  /**
   * All-args constructor.
   */
  public EmployeeSchema(java.lang.Long Id, java.lang.CharSequence firstName, java.lang.CharSequence lastName, java.lang.CharSequence title, java.lang.CharSequence createdDate, java.lang.CharSequence modifiedDate) {
    this.Id = Id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.title = title;
    this.createdDate = createdDate;
    this.modifiedDate = modifiedDate;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return Id;
    case 1: return firstName;
    case 2: return lastName;
    case 3: return title;
    case 4: return createdDate;
    case 5: return modifiedDate;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: Id = (java.lang.Long)value$; break;
    case 1: firstName = (java.lang.CharSequence)value$; break;
    case 2: lastName = (java.lang.CharSequence)value$; break;
    case 3: title = (java.lang.CharSequence)value$; break;
    case 4: createdDate = (java.lang.CharSequence)value$; break;
    case 5: modifiedDate = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'Id' field.
   */
  public java.lang.Long getId() {
    return Id;
  }

  /**
   * Sets the value of the 'Id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Long value) {
    this.Id = value;
  }

  /**
   * Gets the value of the 'firstName' field.
   */
  public java.lang.CharSequence getFirstName() {
    return firstName;
  }

  /**
   * Sets the value of the 'firstName' field.
   * @param value the value to set.
   */
  public void setFirstName(java.lang.CharSequence value) {
    this.firstName = value;
  }

  /**
   * Gets the value of the 'lastName' field.
   */
  public java.lang.CharSequence getLastName() {
    return lastName;
  }

  /**
   * Sets the value of the 'lastName' field.
   * @param value the value to set.
   */
  public void setLastName(java.lang.CharSequence value) {
    this.lastName = value;
  }

  /**
   * Gets the value of the 'title' field.
   */
  public java.lang.CharSequence getTitle() {
    return title;
  }

  /**
   * Sets the value of the 'title' field.
   * @param value the value to set.
   */
  public void setTitle(java.lang.CharSequence value) {
    this.title = value;
  }

  /**
   * Gets the value of the 'createdDate' field.
   */
  public java.lang.CharSequence getCreatedDate() {
    return createdDate;
  }

  /**
   * Sets the value of the 'createdDate' field.
   * @param value the value to set.
   */
  public void setCreatedDate(java.lang.CharSequence value) {
    this.createdDate = value;
  }

  /**
   * Gets the value of the 'modifiedDate' field.
   */
  public java.lang.CharSequence getModifiedDate() {
    return modifiedDate;
  }

  /**
   * Sets the value of the 'modifiedDate' field.
   * @param value the value to set.
   */
  public void setModifiedDate(java.lang.CharSequence value) {
    this.modifiedDate = value;
  }

  /** Creates a new EmployeeSchema RecordBuilder */
  public static akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder newBuilder() {
    return new akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder();
  }
  
  /** Creates a new EmployeeSchema RecordBuilder by copying an existing Builder */
  public static akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder newBuilder(akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder other) {
    return new akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder(other);
  }
  
  /** Creates a new EmployeeSchema RecordBuilder by copying an existing EmployeeSchema instance */
  public static akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder newBuilder(akka.kafka.example.datapush.avro.schema.EmployeeSchema other) {
    return new akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder(other);
  }
  
  /**
   * RecordBuilder for EmployeeSchema instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EmployeeSchema>
    implements org.apache.avro.data.RecordBuilder<EmployeeSchema> {

    private long Id;
    private java.lang.CharSequence firstName;
    private java.lang.CharSequence lastName;
    private java.lang.CharSequence title;
    private java.lang.CharSequence createdDate;
    private java.lang.CharSequence modifiedDate;

    /** Creates a new Builder */
    private Builder() {
      super(akka.kafka.example.datapush.avro.schema.EmployeeSchema.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.Id)) {
        this.Id = data().deepCopy(fields()[0].schema(), other.Id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.firstName)) {
        this.firstName = data().deepCopy(fields()[1].schema(), other.firstName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.lastName)) {
        this.lastName = data().deepCopy(fields()[2].schema(), other.lastName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.title)) {
        this.title = data().deepCopy(fields()[3].schema(), other.title);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.createdDate)) {
        this.createdDate = data().deepCopy(fields()[4].schema(), other.createdDate);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.modifiedDate)) {
        this.modifiedDate = data().deepCopy(fields()[5].schema(), other.modifiedDate);
        fieldSetFlags()[5] = true;
      }
    }
    
    /** Creates a Builder by copying an existing EmployeeSchema instance */
    private Builder(akka.kafka.example.datapush.avro.schema.EmployeeSchema other) {
            super(akka.kafka.example.datapush.avro.schema.EmployeeSchema.SCHEMA$);
      if (isValidValue(fields()[0], other.Id)) {
        this.Id = data().deepCopy(fields()[0].schema(), other.Id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.firstName)) {
        this.firstName = data().deepCopy(fields()[1].schema(), other.firstName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.lastName)) {
        this.lastName = data().deepCopy(fields()[2].schema(), other.lastName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.title)) {
        this.title = data().deepCopy(fields()[3].schema(), other.title);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.createdDate)) {
        this.createdDate = data().deepCopy(fields()[4].schema(), other.createdDate);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.modifiedDate)) {
        this.modifiedDate = data().deepCopy(fields()[5].schema(), other.modifiedDate);
        fieldSetFlags()[5] = true;
      }
    }

    /** Gets the value of the 'Id' field */
    public java.lang.Long getId() {
      return Id;
    }
    
    /** Sets the value of the 'Id' field */
    public akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder setId(long value) {
      validate(fields()[0], value);
      this.Id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'Id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'Id' field */
    public akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'firstName' field */
    public java.lang.CharSequence getFirstName() {
      return firstName;
    }
    
    /** Sets the value of the 'firstName' field */
    public akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder setFirstName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.firstName = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'firstName' field has been set */
    public boolean hasFirstName() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'firstName' field */
    public akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder clearFirstName() {
      firstName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'lastName' field */
    public java.lang.CharSequence getLastName() {
      return lastName;
    }
    
    /** Sets the value of the 'lastName' field */
    public akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder setLastName(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.lastName = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'lastName' field has been set */
    public boolean hasLastName() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'lastName' field */
    public akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder clearLastName() {
      lastName = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'title' field */
    public java.lang.CharSequence getTitle() {
      return title;
    }
    
    /** Sets the value of the 'title' field */
    public akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder setTitle(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.title = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'title' field has been set */
    public boolean hasTitle() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'title' field */
    public akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder clearTitle() {
      title = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'createdDate' field */
    public java.lang.CharSequence getCreatedDate() {
      return createdDate;
    }
    
    /** Sets the value of the 'createdDate' field */
    public akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder setCreatedDate(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.createdDate = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'createdDate' field has been set */
    public boolean hasCreatedDate() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'createdDate' field */
    public akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder clearCreatedDate() {
      createdDate = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'modifiedDate' field */
    public java.lang.CharSequence getModifiedDate() {
      return modifiedDate;
    }
    
    /** Sets the value of the 'modifiedDate' field */
    public akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder setModifiedDate(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.modifiedDate = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'modifiedDate' field has been set */
    public boolean hasModifiedDate() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'modifiedDate' field */
    public akka.kafka.example.datapush.avro.schema.EmployeeSchema.Builder clearModifiedDate() {
      modifiedDate = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public EmployeeSchema build() {
      try {
        EmployeeSchema record = new EmployeeSchema();
        record.Id = fieldSetFlags()[0] ? this.Id : (java.lang.Long) defaultValue(fields()[0]);
        record.firstName = fieldSetFlags()[1] ? this.firstName : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.lastName = fieldSetFlags()[2] ? this.lastName : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.title = fieldSetFlags()[3] ? this.title : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.createdDate = fieldSetFlags()[4] ? this.createdDate : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.modifiedDate = fieldSetFlags()[5] ? this.modifiedDate : (java.lang.CharSequence) defaultValue(fields()[5]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
