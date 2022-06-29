// Generated from com\abtnetworks\totems\whale\plugin\centos\nom\device\CentOS.g4 by ANTLR 4.7.2
package com.abtnetworks.totems.whale.plugin.centos.nom.device;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CentOSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CentOSVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CentOSParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConfig(CentOSParser.ConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(CentOSParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#unknownCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnknownCommand(CentOSParser.UnknownCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#knownCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKnownCommand(CentOSParser.KnownCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#hostname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHostname(CentOSParser.HostnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#hostOs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHostOs(CentOSParser.HostOsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#cpuInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCpuInfo(CentOSParser.CpuInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#cpuUse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCpuUse(CentOSParser.CpuUseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#memInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemInfo(CentOSParser.MemInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#diskInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiskInfo(CentOSParser.DiskInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#diskSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiskSub(CentOSParser.DiskSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#diskUse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiskUse(CentOSParser.DiskUseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#diskUseSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiskUseSub(CentOSParser.DiskUseSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#nicInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNicInfo(CentOSParser.NicInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#nicSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNicSub(CentOSParser.NicSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#nicOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNicOption(CentOSParser.NicOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#netstatInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNetstatInfo(CentOSParser.NetstatInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#netstatSubInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNetstatSubInfo(CentOSParser.NetstatSubInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#processInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcessInfo(CentOSParser.ProcessInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#processSubInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcessSubInfo(CentOSParser.ProcessSubInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#listenList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListenList(CentOSParser.ListenListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#listenSubInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListenSubInfo(CentOSParser.ListenSubInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#accessList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessList(CentOSParser.AccessListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#accessSubInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessSubInfo(CentOSParser.AccessSubInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#userInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserInfo(CentOSParser.UserInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#userInfoSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserInfoSub(CentOSParser.UserInfoSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#iptablesInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIptablesInfo(CentOSParser.IptablesInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#iptablesSubInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIptablesSubInfo(CentOSParser.IptablesSubInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#chainRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChainRule(CentOSParser.ChainRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#unknownMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnknownMember(CentOSParser.UnknownMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(CentOSParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#rout_itf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_itf(CentOSParser.Rout_itfContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(CentOSParser.WordContext ctx);
	/**
	 * Visit a parse tree produced by {@link CentOSParser#eol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEol(CentOSParser.EolContext ctx);
}