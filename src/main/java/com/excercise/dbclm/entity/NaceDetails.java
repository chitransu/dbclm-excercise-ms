package com.excercise.dbclm.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NaceDetails")
public class NaceDetails {
	
	@Id
	@Column(name="Order_id")
	private String orderId;
	@Column(name="Level")
    private String level;
	@Column(name="Code")
    private String code;
	@Column(name="Parent")
    private String parent;
	@Column(name="Description")
    private String description;
	@Lob
	@Column(name="This_item_includes", columnDefinition = "CLOB")
    private String thisItemIncludes;
	@Lob
	@Column(name="This_item_also_includes", columnDefinition = "CLOB")
    private String thisItemAlsoIncludes;
	@Column(name="Ruling")
    private String ruling;
	@Lob
	@Column(name="This_item_excludes", columnDefinition = "CLOB")
    private String thisItemExcludes;
	@Column(name="Reference_to_isic_rev4")
    private String referenceToISICRev4;
    
}
