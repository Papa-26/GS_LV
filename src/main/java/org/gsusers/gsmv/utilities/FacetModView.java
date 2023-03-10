package org.gsusers.gsmv.utilities;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import org.gsusers.gsmv.model.Facet;

/**
 * 'FacetModView' is used as a display/control class in
 * the 'Analysis' scene of 'AnaGroups' (Step 10). It allows
 * changing the properties of facets in D-Studies.
 *
 * @see <a href="https://github.com/G-String-Legacy/G_String/blob/main/workbench/GS_L/src/utilities/FacetModView.java">utilities.FacetModView</a>
 * @author ralph
 * @version %v..%
 */
public class FacetModView extends HBox{

	/**
	 * position in sDictionary
	 */
	//private Integer id = -1;

	/**
	 * 'average' sample size
	 */
	//private Double dLevel = 0.0;

	/**
	 * rounded 'average' sample size
	 */
	private Integer iLevel = 0;

	/**
	 * descriptive name of Facet
	 */
	private String sName = null;

	/**
	 * boolean flag fixed/random -> true/false
	 */
	//private Boolean bFixed = false;

	/**
	 * constructor
	 *
	 * @param f  Facet
	 */
	public FacetModView (Facet f)
	{
		CheckBox cbFixed = null;
		this.setPadding(new Insets(0, 0, 0, 3));
		sName = f.getName();
		iLevel = (int) Math.round(f.getFacetLevel());
		//bFixed = f.getFixed();
		Label lbName = new Label(sName);
		lbName.setMinWidth(60.0);
		TextField tfLevel = new TextField(iLevel.toString());
		tfLevel.setPrefWidth(80);
		tfLevel.setAlignment(Pos.CENTER_RIGHT);
		tfLevel.textProperty().addListener((observable, oldValue, newValue) -> {
			if (oldValue != newValue)
			{
				Double dTemp = Double.parseDouble(newValue);
				f.setdFacetLevel(dTemp);
			}
		});
		Boolean bFixed = f.getFixed();
		if (!bFixed)
			cbFixed = new CheckBox("Random");
		else
			cbFixed = new CheckBox("Fixed");
		cbFixed.setSelected(bFixed);
		cbFixed.setPadding(new Insets(0,0,8,3));
		cbFixed.selectedProperty().addListener(new ChangeListener<Boolean>() {
	           @Override
			public void changed(ObservableValue<? extends Boolean> ov,
	                 Boolean old_val, Boolean new_val)
	           		{
	                   if (old_val != new_val)
	                	   f.setFixed(new_val);
	           		}
	              });
		this.setAlignment(Pos.CENTER_LEFT);
		this.getChildren().addAll(lbName, tfLevel, cbFixed);
	}
}
