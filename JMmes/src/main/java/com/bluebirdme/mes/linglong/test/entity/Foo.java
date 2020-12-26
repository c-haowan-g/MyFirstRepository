/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

/**
 * FFFF
 * @author 高飞
 * @Date 2018-08-23 14:27:23
 */
@ATDefinition("FOO")
@Entity
@XmlRootElement
@Table(name="AT_FOO")
public class Foo extends RockWellBaseEntity{
    
    
    @Comment("BIRTHDAY_T")
    @Column(nullable=true,length=11)
    private Date birthday_t;
    
    @Comment("NAME_S")
    @Column(nullable=true,length=160)
    private String name_s;
    
    public Date getBirthday_t(){
        return birthday_t;
    }
    
    @XmlElement
    public void setBirthday_t(Date birthday_t){
        this.birthday_t=birthday_t;
    }
        
    public String getName_s(){
        return name_s;
    }
    
    @XmlElement
    public void setName_s(String name_s){
        this.name_s=name_s;
    }
        
    
    
    
}
