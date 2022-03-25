import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并服务
 *
 * @author
 */
public class BaseMergeManager {

    /**
     * 坐席的模型
     */
    @Getter
    @Setter
    @ToString
    public class AgentModel{
        private String agentName;
        private Long agentUid;
    }

    /**
     * 技能组的模型
     */
    @Getter
    @Setter
    @ToString
    public class SkillModel{
        private String skillName;
        private Long skillId;
    }

    /**
     * 坐席和技能组的关联模型
     */
    @Getter
    @Setter
    @ToString
    public class AgentSkillRelationModel{
        private Double skillId;
        private String agentUid;
    }

    /**
     * 坐席分页查询的结果模型
     */
    @Getter
    @Setter
    @ToString
    public class AgentResultModel{
        private String agentName;
        private List<SkillModel> skillList;
    }

    /**
     * 题目要求：
     * https://img.alicdn.com/imgextra/i4/O1CN01BeeSQi1RVdBohYs7x_!!6000000002117-2-tps-820-293.png
     * 1.遍历agentList，如果列表元素的字段agentUid在relationList有agentUid相等，则找到所有满足条件的skillId
     * 2.找到skillId的集合后，从skillList找到skillId与之相等的所有对象
     * 3.将坐席模型、和获取到的坐席关联的技能模型合并设置到结果AgentResultModel模型中
     * 例如：
     * 入参：
     * agentList=[{"agentUid":1,"agentName":"张三"}]
     * skillList=[{"skillId":2,"skillName":"IT工程师"}]
     * relationList=[{"skillId":2.0,"agentUid":"1"}]
     *
     * 返回值：
     * [{"agentName":"张三","skillList":[{"skillId":2,"skillName":"IT工程师"}]}]
     *
     * @param agentList 坐席列表
     * @param skillList 技能列表
     * @param relationList 坐席技能关联列表
     * @return 坐席合并结果列表
     */
    public List<AgentResultModel> merge(List<AgentModel> agentList,List<SkillModel> skillList,
    List<AgentSkillRelationModel> relationList){
        List<AgentResultModel> mergeList = new ArrayList<>(agentList.size());
        List<AgentModel> newAgentList = new ArrayList<>();//这个集合供第三题使用；
        List<AgentSkillRelationModel> newAgentSkillRelationModelList = new ArrayList<>();//这个集合供第三题使用；
        //此处答题
        //1.遍历agentList，如果列表元素的字段agentUid在relationList有agentUid相等，则找到所有满足条件的skillId
        if (null == agentList || agentList.size() == 0 || null == relationList || relationList.size() == 0) return null;
        List<Double> skillIdList = new ArrayList<>();
        for (AgentModel agentModel : agentList) {
            for (AgentSkillRelationModel agentSkillRelationModel : relationList) {
                if (agentModel.getAgentUid().toString().equals(agentSkillRelationModel.getAgentUid())){
                    skillIdList.add(agentSkillRelationModel.getSkillId());
                    newAgentList.add(agentModel);
                    newAgentSkillRelationModelList.add(agentSkillRelationModel);
                    continue;//找到了  退出内循环
                }
            }
        }
        System.out.println("第一题：所有满足条件的skillId:"+skillIdList);

        //2.找到skillId的集合后，从skillList找到skillId与之相等的所有对象
        if (null == skillList || skillList.size() == 0) return null;
        List<SkillModel> newSkillList = new ArrayList<>();
        for (Double aDouble : skillIdList) {
            for (SkillModel skillModel : skillList) {
                if (aDouble == Double.valueOf(skillModel.getSkillId())){
                    newSkillList.add(skillModel);
                    continue;//找到了  退出内循环
                }
            }
        }
        System.out.println("第二题：从skillList找到skillId与之相等的所有对象:"+newSkillList);

        //3.将坐席模型、和获取到的坐席关联的技能模型合并设置到结果AgentResultModel模型中
        for (AgentModel agentModel : newAgentList) {
            for (AgentSkillRelationModel agentSkillRelationModel : newAgentSkillRelationModelList) {
                if (agentModel.getAgentUid().toString().equals(agentSkillRelationModel.getAgentUid())){
                    AgentResultModel agentResultModel = new AgentResultModel();
                    List<SkillModel> skillArray = new ArrayList<>();
                    for (SkillModel skillModel : newSkillList) {
                        if (agentSkillRelationModel.getSkillId().toString().equals(skillModel.getSkillId().toString())){
                            skillArray.add(skillModel);
                        }
                    }
                    agentResultModel.setAgentName(agentModel.getAgentName());
                    agentResultModel.setSkillList(skillArray);
                    mergeList.add(agentResultModel);
                    continue;//找到了  退出内循环
                }
            }
        }
        System.out.println("第三题：将坐席模型、和获取到的坐席关联的技能模型合并设置到结果:"+mergeList);

        //TODO 特别注释：为了第三题声明了 newAgentList newAgentSkillRelationModelList对象，
        // 目的是在第一题的时候就可以筛选掉不必要的结果，这样避免不必要的循环查找，提高性能
        // 第一题在查找前  agentList relationList 根据AgentUid排序一下再查找，
        // 第二题 skillIdList skillList根据SkillId排序一下或许性能更佳，但是排序也会损坏性能，这个可以测试一下
        return mergeList;
    }
}
