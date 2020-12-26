<?xml version="1.0" encoding="UTF-8"?>
<sqls>
    <sql comment="datagrid" id="datagrid_rows">
        <![CDATA[
            select * from ${tableName} where 1=1
            <#list columns as c>
                ${"<#if"} ${c.name?lower_case}${"??>"}
                     and ${c.name}=:${c.name?lower_case}
                ${"</#if>"}
            </#list>
            ${"<#if"} sort${"??&&"}order${"??>"}
                order by ${"${"}sort${"}"} ${"${"}order${"}"}
                ${"<#else>"}
                order by atr_key desc
            ${"</#if>"}
        ]]>
    </sql>
    <sql comment="datagrid" id="datagrid_total">
        <![CDATA[
            select count(1) from ${tableName} where 1=1
              <#list columns as c>
                    ${"<#if"} ${c.name?lower_case}${"??>"}
                         and ${c.name}=:${c.name?lower_case}
                    ${"</#if>"}
              </#list>
        ]]>
    </sql>
</sqls>