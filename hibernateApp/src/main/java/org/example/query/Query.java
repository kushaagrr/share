package org.example.query;

public class Query {
    private String query;

    public Query(StringPair[] params){
        int size = params.length;
        StringBuilder sb = new StringBuilder();
        sb.append("select t from Tshirt t where ");
        int pos = 0;
        for(StringPair prop: params){
            String condition = "t." + prop.getKey() + "=" + "'"+ prop.getValue() +"'";
            if(pos != size - 1){
                condition = condition.concat(" and ");
            }
            sb.append(condition);
            pos += 1;
        }
        this.query = sb.toString();
    }
    public String getQuery(){
        return this.query;
    }
}
