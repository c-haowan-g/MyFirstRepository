<?xml version="1.0" encoding="UTF-8"?>
<sqls>
    <sql comment="datagridUDA" id="datagridUDA_rows">
        <![CDATA[
            select * from ${tableName},UDA_${tableName} where 1=1
            	AND UDA_${tableName}.OBJECT_KEY = ${tableName}.${entityName?upper_case}_KEY
            <#list columns as c>
                ${"<#if"} ${c.db_name?lower_case}${"??>"}
                     and ${c.db_name}=:${c.db_name?lower_case}
                ${"</#if>"}
            </#list>
            ${"<#if"} sort${"??&&"}order${"??>"}
                order by ${"${"}sort${"}"} ${"${"}order${"}"}
                ${"<#else>"}
                order by ${tableName}.${entityName?lower_case}_key desc
            ${"</#if>"}
        ]]>
    </sql>
    <sql comment="datagridUDA" id="datagridUDA_total">
        <![CDATA[
            select count(1) from ${tableName},UDA_${tableName} where 1=1
            AND UDA_${tableName}.OBJECT_KEY = ${tableName}.${entityName?upper_case}_KEY
              <#list columns as c>
                    ${"<#if"} ${c.db_name?lower_case}${"??>"}
                         and ${c.db_name}=:${c.db_name?lower_case}
                    ${"</#if>"}
              </#list>
        ]]>
    </sql>
</sqls>