package org.verapdf.model.factory.operator;

import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.verapdf.model.impl.pb.operator.color.PBOpColor;
import org.verapdf.model.impl.pb.operator.generalgs.*;
import org.verapdf.model.impl.pb.operator.inlineimage.PBOpInlineImage;
import org.verapdf.model.impl.pb.operator.markedcontent.*;
import org.verapdf.model.impl.pb.operator.opclip.PBOp_WStar;
import org.verapdf.model.impl.pb.operator.opclip.PBOp_W_clip;
import org.verapdf.model.impl.pb.operator.opcompability.PBOp_BX;
import org.verapdf.model.impl.pb.operator.opcompability.PBOp_EX;
import org.verapdf.model.impl.pb.operator.opcompability.PBOp_Undefined;
import org.verapdf.model.impl.pb.operator.pathconstruction.*;
import org.verapdf.model.impl.pb.operator.pathpaint.*;
import org.verapdf.model.impl.pb.operator.shading.PBOp_sh;
import org.verapdf.model.impl.pb.operator.specialgs.PBOp_Q_grestore;
import org.verapdf.model.impl.pb.operator.specialgs.PBOp_cm;
import org.verapdf.model.impl.pb.operator.specialgs.PBOp_q_gsave;
import org.verapdf.model.impl.pb.operator.textobject.PBOpTextObject;
import org.verapdf.model.impl.pb.operator.textposition.PBOpTextPosition;
import org.verapdf.model.impl.pb.operator.textposition.PBOp_TD_Big;
import org.verapdf.model.impl.pb.operator.textposition.PBOp_Td;
import org.verapdf.model.impl.pb.operator.textshow.PBOp_DoubleQuote;
import org.verapdf.model.impl.pb.operator.textshow.PBOp_Quote;
import org.verapdf.model.impl.pb.operator.textshow.PBOp_TJ_Big;
import org.verapdf.model.impl.pb.operator.textshow.PBOp_Tj;
import org.verapdf.model.impl.pb.operator.textstate.PBOpTextState;
import org.verapdf.model.impl.pb.operator.textstate.PBOp_Tr;
import org.verapdf.model.impl.pb.operator.textstate.PBOp_Tz;
import org.verapdf.model.impl.pb.operator.type3font.PBOpType3Font;
import org.verapdf.model.impl.pb.operator.xobject.PBOp_Do;
import org.verapdf.model.tools.constants.Operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Evgeniy Muravitskiy
 */
@RunWith(Parameterized.class)
public class OperatorParserTest {

	public static final List<COSBase> arguments = new ArrayList<>(0);
	public static final PDResources RESOURCES = new PDResources(new COSDictionary());
	private static final String UNDEFINED = "Undefined";

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		List<Object[]> parameters = new ArrayList<>();
		parameters.add(new Object[] {Operator.getOperator(Operators.D_SET_DASH), PBOp_d.OP_D_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.GS), PBOp_gs.OP_GS_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.I_SETFLAT), PBOp_i.OP_I_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.J_LINE_CAP), PBOp_J_line_cap.OP_J_LINE_CAP_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.J_LINE_JOIN), PBOp_j_line_join.OP_J_LINE_JOIN_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.M_MITER_LIMIT), PBOp_M_miter_limit.OP_M_MITER_LIMIT_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.RI), PBOp_ri.OP_RI_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.W_LINE_WIDTH), PBOp_w_line_width.OP_W_LINE_WIDTH_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.BMC), PBOp_BMC.OP_BMC_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.BDC), PBOp_BDC.OP_BDC_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.EMC), PBOp_EMC.OP_EMC_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.MP), PBOp_MP.OP_MP_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.DP), PBOp_DP.OP_DP_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.W_CLIP), PBOp_W_clip.OP_W_CLIP_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.W_STAR_EOCLIP), PBOp_WStar.OP_WSTAR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.G_STROKE), PBOpColor.OP_COLOR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.G_FILL), PBOpColor.OP_COLOR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.RG_STROKE), PBOpColor.OP_COLOR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.RG_FILL), PBOpColor.OP_COLOR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.K_STROKE), PBOpColor.OP_COLOR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.K_FILL), PBOpColor.OP_COLOR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.CS_STROKE), PBOpColor.OP_COLOR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.CS_FILL), PBOpColor.OP_COLOR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.SCN_STROKE), PBOpColor.OP_COLOR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.SCN_FILL), PBOpColor.OP_COLOR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.SC_STROKE), PBOpColor.OP_COLOR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.SC_FILL), PBOpColor.OP_COLOR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.ET), PBOpTextObject.OP_TEXT_OBJECT_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.BT), PBOpTextObject.OP_TEXT_OBJECT_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.TD_MOVE), PBOp_Td.OP_TD_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.TD_MOVE_SET_LEADING), PBOp_TD_Big.OP_TD_BIG_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.TM), PBOpTextPosition.OP_TEXT_POSITION_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.T_STAR), PBOpTextPosition.OP_TEXT_POSITION_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.TJ_SHOW), PBOp_Tj.OP_TJ_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.TJ_SHOW_POS), PBOp_TJ_Big.OP_TJ_BIG_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.QUOTE), PBOp_Quote.OP_QUOTE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.DOUBLE_QUOTE), PBOp_DoubleQuote.OP_DOUBLIE_QUOTE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.TZ), PBOp_Tz.OP_TZ_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.TR), PBOp_Tr.OP_TR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.TF), PBOpTextState.OP_TEXT_STATE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.TC), PBOpTextState.OP_TEXT_STATE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.TW), PBOpTextState.OP_TEXT_STATE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.TL), PBOpTextState.OP_TEXT_STATE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.TS), PBOpTextState.OP_TEXT_STATE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.D0), PBOpType3Font.OP_TYPE_3_FONT_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.D1), PBOpType3Font.OP_TYPE_3_FONT_TYPE});
		// TODO : is it correct??
		parameters.add(new Object[] {Operator.getOperator(Operators.BI), PBOpInlineImage.OP_INLINE_IMAGE});
		parameters.add(new Object[] {Operator.getOperator(Operators.ID), PBOpInlineImage.OP_INLINE_IMAGE});
		parameters.add(new Object[] {Operator.getOperator(Operators.EI), PBOpInlineImage.OP_INLINE_IMAGE});
		parameters.add(new Object[] {Operator.getOperator(Operators.BX), PBOp_BX.OP_BX_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.EX), PBOp_EX.OP_EX_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.C_CURVE_TO), PBOp_c.OP_C_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.H_CLOSEPATH), PBOp_h.OP_H_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.L_LINE_TO), PBOp_l.OP_L_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.M_MOVE_TO), PBOp_m_moveto.OP_M_MOVETO_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.RE), PBOp_re.OP_RE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.V), PBOp_v.OP_V_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.Y), PBOp_y.OP_Y_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.B_CLOSEPATH_FILL_STROKE),
				PBOp_b_closepath_fill_stroke.OP_B_CLOSEPATH_FILL_STROKE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.B_FILL_STROKE),
				PBOp_B_fill_stroke.OP_B_FILL_STROKE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.B_STAR_CLOSEPATH_EOFILL_STROKE),
				PBOp_bstar_closepath_eofill_stroke.OP_BSTAR_CLOSEPATH_EOFILL_STROKE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.B_STAR_EOFILL_STROKE),
				PBOp_BStar_eofill_stroke.OP_BSTAR_EOFILL_STROKE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.F_FILL), PBOp_f_fill.OP_F_FILL_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.F_FILL_OBSOLETE),
				PBOp_F_fill_obsolete.OP_F_FILL_OBSOLETE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.F_STAR_FILL), PBOp_FStar.OP_FSTAR_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.N), PBOp_n.OP_N_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.S_CLOSE_STROKE),
				PBOp_s_close_stroke.OP_S_CLOSE_STROKE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.S_STROKE), PBOp_S_stroke.OP_S_STROKE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.SH), PBOp_sh.OP_SH_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.CM_CONCAT), PBOp_cm.OP_CM_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.Q_GRESTORE), PBOp_Q_grestore.OP_Q_GRESTORE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.Q_GSAVE), PBOp_q_gsave.OP_Q_GSAVE_TYPE});
		parameters.add(new Object[] {Operator.getOperator(Operators.DO), PBOp_Do.OP_DO_TYPE});
		parameters.add(new Object[] {Operator.getOperator(UNDEFINED), PBOp_Undefined.OP_UNDEFINED_TYPE});
		return parameters;
	}

	@Parameterized.Parameter
	public Operator operator;

	@Parameterized.Parameter(value = 1)
	public String expectedType;

	@Test
	public void testParseOperatorMethod() {
		//OperatorParser.parseOperator();
		List<Object> operator = new ArrayList<>(1);
		operator.add(this.operator);
		Assert.assertEquals(expectedType, OperatorFactory.operatorsFromTokens(operator, RESOURCES).get(0).getType());
	}

}