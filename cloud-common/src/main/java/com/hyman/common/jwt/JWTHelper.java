package com.hyman.common.jwt;

import com.hyman.common.constant.CommonConstants;
import com.hyman.common.exception.auth.ClientTokenException;
import com.hyman.common.jwt.vo.JWTInfo;
import com.hyman.common.util.qiyuesuosdk.lang.StringUtils;
import com.google.common.base.Strings;
import io.jsonwebtoken.*;
import org.joda.time.DateTime;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

/**
 * @Author
 * @Date: 2018/5/3 16:28
 * @Description:
 */
public class JWTHelper {

    private final static String base64Secret = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";
    static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    public static Key genSigningKey() {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }

    /**
     * 密钥加密token
     *
     * @param jwtInfo
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(JWTInfo jwtInfo, int expire) {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getOpenId())
                .claim(CommonConstants.JWT_KEY_PROFILE, jwtInfo.getProfile())
                .claim(CommonConstants.JWT_KEY_OPENID, jwtInfo.getOpenId())
                .claim(CommonConstants.JWT_KEY_USER_ID, StringUtils.isNotBlank(jwtInfo.getThirdPartyId())  ? jwtInfo.getThirdPartyId() : jwtInfo.getUserId())
                .claim(CommonConstants.JWT_KEY_USERNAME, jwtInfo.getUsername())
                .claim(CommonConstants.JWT_KEY_PHONE, jwtInfo.getPhone())
                .claim(CommonConstants.JWT_KEY_TYPE, jwtInfo.getType())
                .claim(CommonConstants.USER_BUSI_PERMISSION, jwtInfo.getBusiPermission())
                .claim(CommonConstants.USER_BUSI_LOGIN_FLAG,jwtInfo.getLoginFlag())
                .claim(CommonConstants.JWT_KEY_SYSTEMTYPE,jwtInfo.getSystemtype())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(signatureAlgorithm, genSigningKey())
                .compact();
        return compactJws;
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Secret)).parseClaimsJws(token);
        return claimsJws;
    }

    /**
     * 获取token中的用户信息
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Claims getInfoFromToken(String token) {
        try {
            if (Strings.isNullOrEmpty(token)) {
                throw new ClientTokenException("客户端Token为空");
            }
            Jws<Claims> claimsJws = parserToken(token);
            Claims body = claimsJws.getBody();
            return body;
        } catch (ExpiredJwtException ex) {
            throw new ClientTokenException("Token已过期," + ex.getMessage());
        } catch (SignatureException ex) {
            throw new ClientTokenException("解析Token错误," + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            throw new ClientTokenException("Token 非法," + ex.getMessage());
        } catch (Exception ex) {
            throw new ClientTokenException("Token格式错误," + ex.getMessage());
        }
    }

}
