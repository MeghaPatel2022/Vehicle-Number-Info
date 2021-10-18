package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Creator<InvitationEntity> CREATOR = new InvitationEntityCreatorCompat();
    private final int mVersionCode;
    private final String zzate;
    private final GameEntity zzaxY;
    private final long zzaxZ;
    private final int zzaya;
    private final ParticipantEntity zzayb;
    private final ArrayList<ParticipantEntity> zzayc;
    private final int zzayd;
    private final int zzaye;

    static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
        InvitationEntityCreatorCompat() {
        }

        /* renamed from: zzdT */
        public InvitationEntity createFromParcel(Parcel parcel) {
            if (InvitationEntity.zzd(InvitationEntity.zzor()) || InvitationEntity.zzcj(InvitationEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity participantEntity = (ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(2, gameEntity, readString, readLong, readInt, participantEntity, arrayList, -1, 0);
        }
    }

    InvitationEntity(int versionCode, GameEntity game, String invitationId, long creationTimestamp, int invitationType, ParticipantEntity inviter, ArrayList<ParticipantEntity> participants, int variant, int availableAutoMatchSlots) {
        this.mVersionCode = versionCode;
        this.zzaxY = game;
        this.zzate = invitationId;
        this.zzaxZ = creationTimestamp;
        this.zzaya = invitationType;
        this.zzayb = inviter;
        this.zzayc = participants;
        this.zzayd = variant;
        this.zzaye = availableAutoMatchSlots;
    }

    InvitationEntity(Invitation invitation) {
        this.mVersionCode = 2;
        this.zzaxY = new GameEntity(invitation.getGame());
        this.zzate = invitation.getInvitationId();
        this.zzaxZ = invitation.getCreationTimestamp();
        this.zzaya = invitation.getInvitationType();
        this.zzayd = invitation.getVariant();
        this.zzaye = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        Participant participant = null;
        ArrayList participants = invitation.getParticipants();
        int size = participants.size();
        this.zzayc = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Participant participant2 = (Participant) participants.get(i);
            if (participant2.getParticipantId().equals(participantId)) {
                participant = participant2;
            }
            this.zzayc.add((ParticipantEntity) participant2.freeze());
        }
        zzx.zzb(participant, (Object) "Must have a valid inviter!");
        this.zzayb = (ParticipantEntity) participant.freeze();
    }

    static int zza(Invitation invitation) {
        return zzw.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static boolean zza(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return zzw.equal(invitation2.getGame(), invitation.getGame()) && zzw.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && zzw.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && zzw.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && zzw.equal(invitation2.getInviter(), invitation.getInviter()) && zzw.equal(invitation2.getParticipants(), invitation.getParticipants()) && zzw.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && zzw.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static String zzb(Invitation invitation) {
        return zzw.zzu(invitation).zzg("Game", invitation.getGame()).zzg("InvitationId", invitation.getInvitationId()).zzg("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).zzg("InvitationType", Integer.valueOf(invitation.getInvitationType())).zzg("Inviter", invitation.getInviter()).zzg("Participants", invitation.getParticipants()).zzg("Variant", Integer.valueOf(invitation.getVariant())).zzg("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        return this.zzaye;
    }

    public long getCreationTimestamp() {
        return this.zzaxZ;
    }

    public Game getGame() {
        return this.zzaxY;
    }

    public String getInvitationId() {
        return this.zzate;
    }

    public int getInvitationType() {
        return this.zzaya;
    }

    public Participant getInviter() {
        return this.zzayb;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.zzayc);
    }

    public int getVariant() {
        return this.zzayd;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (!zzos()) {
            InvitationEntityCreator.zza(this, dest, flags);
            return;
        }
        this.zzaxY.writeToParcel(dest, flags);
        dest.writeString(this.zzate);
        dest.writeLong(this.zzaxZ);
        dest.writeInt(this.zzaya);
        this.zzayb.writeToParcel(dest, flags);
        int size = this.zzayc.size();
        dest.writeInt(size);
        for (int i = 0; i < size; i++) {
            ((ParticipantEntity) this.zzayc.get(i)).writeToParcel(dest, flags);
        }
    }
}
