import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class BaseMergeManagerTest extends BaseMergeManager {

    @Test
    public void mergeTest() {
        List<AgentModel> agentList = new ArrayList<>();
        List<AgentSkillRelationModel> relationList = new ArrayList<>();
        List<SkillModel> skillList = new ArrayList<>();

        //一：造数：创建100000供测试的对象
        for (int i = 0; i < 1000; i++) {
            long agentUid = i;
            String agentName = agentUid + "_AgentName";

            Double skillId = Double.valueOf(100000 + i);
            String SkillName = skillId + "_SkillName";

            //创建AgentModel对象
            AgentModel agentModel = new AgentModel();
            agentModel.setAgentUid(agentUid);
            agentModel.setAgentName(agentName);
            agentList.add(agentModel);

            //创建AgentSkillRelationModel对象
            AgentSkillRelationModel agentSkillRelationModel = new AgentSkillRelationModel();
            agentSkillRelationModel.setAgentUid(String.valueOf(agentUid));
            agentSkillRelationModel.setSkillId(skillId);
            relationList.add(agentSkillRelationModel);

            //创建SkillModel对象
            SkillModel akillModel = new SkillModel();
            akillModel.setSkillId(Long.valueOf((long) Math.floor(skillId)));
            akillModel.setSkillName(SkillName);
            skillList.add(akillModel);
        }
        //二：测试：调用merge 进行测试
        List<AgentResultModel> list = super.merge(agentList, skillList, relationList);
        System.out.println("测试结果：" + list);
    }


}