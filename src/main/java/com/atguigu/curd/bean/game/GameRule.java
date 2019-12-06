package com.atguigu.curd.bean.game;
import com.atguigu.curd.bean.role.GameDefiner;

/**
 * @Auther: 苏小乐
 * @Date: 2019/11/2 08:48
 * @Description:
 */
public class GameRule {
    String ruleId;              // 博弈规则编号
    long timestamp;             // 时间戳
    GameDefiner gameDefiner;    // 博弈规则指定方
    PrtpRequire prtpRequire;    // 参与方要求
    VerifyAgency verifyAgency;  // 验证方
    AcceptanceCriteria acceptanceCriteria; // 验收标准
    GameAward gameAward;        // 博弈收益
}
