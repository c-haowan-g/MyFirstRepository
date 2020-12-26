package com.bluebirdme.mes.linglong.mix.entity;

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ATDefinition("MX_PP_WO_EDIT")
@XmlRootElement
@Table(name="AT_MX_PP_WO_EDIT")
public class MixBatchReportAll
{

  @Comment("物料编码")
  @Column(nullable=true, length=100)
  private String material_code_s;

  @Comment("物料名称")
  @Column(nullable=true, length=200)
  private String material_name_s;
  private Integer qtyplan;
  private Integer qtycomplete;

  public Integer getQtyplan()
  {
    return this.qtyplan;
  }

  public void setQtyplan(Integer qtyplan) {
    this.qtyplan = qtyplan;
  }

  public Integer getQtycomplete() {
    return this.qtycomplete;
  }

  public void setQtycomplete(Integer qtycomplete) {
    this.qtycomplete = qtycomplete;
  }

  public String getMaterial_code_s()
  {
    return this.material_code_s;
  }

  @XmlElement
  public void setMaterial_code_s(String material_code_s) {
    this.material_code_s = material_code_s;
  }

  public String getMaterial_name_s() {
    return this.material_name_s;
  }

  @XmlElement
  public void setMaterial_name_s(String material_name_s) {
    this.material_name_s = material_name_s;
  }
}