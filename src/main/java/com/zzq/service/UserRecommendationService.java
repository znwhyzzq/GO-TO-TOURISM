package com.zzq.service;

import com.zzq.entity.Collection;
import com.zzq.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 86187
 */
@Service
public class UserRecommendationService {

    @Autowired
    private CollectionMapper collectionMapper;

    public List<Long> getSimilarUserIds(Long userId) {
        // 获取所有用户的收藏数据
        List<Collection> allCollections = collectionMapper.selectList(null);

        // 构建用户-物品交互矩阵
        Map<Long, Map<Long, Integer>> userItemInteractions = new HashMap<>();
        for (Collection collection : allCollections) {
            Long otherUserId = collection.getUserId();
            Long productId = collection.getProductId();
            userItemInteractions.putIfAbsent(otherUserId, new HashMap<>());
            userItemInteractions.get(otherUserId).put(productId, 1); // 1代表收藏
        }

        // 计算余弦相似度
        List<Long> similarUserIds = new ArrayList<>();
        if (userItemInteractions.containsKey(userId)) {
            for (Map.Entry<Long, Map<Long, Integer>> entry : userItemInteractions.entrySet()) {
                Long otherUserId = entry.getKey();
                if (!otherUserId.equals(userId)) {
                    double similarity = calculateCosineSimilarity(userItemInteractions.get(userId), entry.getValue());
                    if (similarity > 0.5) { // 举例，只有当相似度大于0.5时才认为是相似用户
                        System.out.println(similarity);
                        similarUserIds.add(otherUserId);
                    }
                }
            }
        }

        return similarUserIds;
    }

    private double calculateCosineSimilarity(Map<Long, Integer> user1, Map<Long, Integer> user2) {
        Set<Long> commonItems = new HashSet<>(user1.keySet());
        commonItems.retainAll(user2.keySet());
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (Long item : commonItems) {
            dotProduct += user1.get(item) * user2.get(item);
        }
        for (int value : user1.values()) {
            normA += Math.pow(value, 2);
        }
        for (int value : user2.values()) {
            normB += Math.pow(value, 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}
