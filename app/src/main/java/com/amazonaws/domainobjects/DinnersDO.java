package com.amazonaws.domainobjects;


import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "cookin-mobilehub-1855759690-Dinners")

public class DinnersDO {
    private String _dinnerType;
    private String _dinnerId;
    private String _byUser;
    private Double _startDate;

    @DynamoDBHashKey(attributeName = "dinnerType")
    @DynamoDBAttribute(attributeName = "dinnerType")
    public String getDinnerType() {
        return _dinnerType;
    }

    public void setDinnerType(final String _dinnerType) {
        this._dinnerType = _dinnerType;
    }
    @DynamoDBRangeKey(attributeName = "dinnerId")
    @DynamoDBIndexHashKey(attributeName = "dinnerId", globalSecondaryIndexName = "dinnerId-index")
    public String getDinnerId() {
        return _dinnerId;
    }

    public void setDinnerId(final String _dinnerId) {
        this._dinnerId = _dinnerId;
    }
    @DynamoDBIndexHashKey(attributeName = "byUser", globalSecondaryIndexName = "byUser-startDate-index")
    public String getByUser() {
        return _byUser;
    }

    public void setByUser(final String _byUser) {
        this._byUser = _byUser;
    }
    @DynamoDBIndexRangeKey(attributeName = "startDate", globalSecondaryIndexName = "byUser-startDate-index")
    public Double getStartDate() {
        return _startDate;
    }

    public void setStartDate(final Double _startDate) {
        this._startDate = _startDate;
    }

}
